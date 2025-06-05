package br.com.fiap.gestaoabrigos.controller;

import br.com.fiap.gestaoabrigos.dto.ResgatadoDTO;
import br.com.fiap.gestaoabrigos.model.Resgatado;
import br.com.fiap.gestaoabrigos.service.ResgatadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/resgatados")
public class ResgatadoController {

    @Autowired
    private ResgatadoService service;

    @GetMapping
    public Page<Resgatado> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resgatado> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Resgatado> salvar(@Valid @RequestBody ResgatadoDTO dto) {
        Resgatado resgatado = new Resgatado();
        resgatado.setId(dto.getId());
        resgatado.setCpf(dto.getCpf());
        resgatado.setNome(dto.getNome());
        resgatado.setEstadoSaude(dto.getEstadoSaude());
        resgatado.setDataHoraResgate(dto.getDataHoraResgate());
        resgatado.setDdd(dto.getDdd());
        resgatado.setNumeroCel(dto.getNumeroCel());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(resgatado, dto.getIdAbrigo(), dto.getIdEvento()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resgatado> editar(@PathVariable Integer id, @Valid @RequestBody ResgatadoDTO dto) {
        return service.buscarPorId(id)
                .map((old) -> {
                    old.setCpf(dto.getCpf());
                    old.setNome(dto.getNome());
                    old.setEstadoSaude(dto.getEstadoSaude());
                    old.setDataHoraResgate(dto.getDataHoraResgate());
                    old.setDdd(dto.getDdd());
                    old.setNumeroCel(dto.getNumeroCel());
                    return ResponseEntity.ok(service.salvar(old, dto.getIdAbrigo(), dto.getIdEvento()));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        if (service.buscarPorId(id).isEmpty())
            return ResponseEntity.notFound().build();
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}