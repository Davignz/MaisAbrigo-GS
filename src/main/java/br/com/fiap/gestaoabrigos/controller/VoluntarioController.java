package br.com.fiap.gestaoabrigos.controller;

import br.com.fiap.gestaoabrigos.dto.VoluntarioDTO;
import br.com.fiap.gestaoabrigos.model.Voluntario;
import br.com.fiap.gestaoabrigos.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService service;

    @GetMapping
    public Page<Voluntario> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Voluntario> salvar(@Valid @RequestBody VoluntarioDTO dto) {
        Voluntario voluntario = new Voluntario();
        voluntario.setId(dto.getId());
        voluntario.setCpf(dto.getCpf());
        voluntario.setNome(dto.getNome());
        voluntario.setDdd(dto.getDdd());
        voluntario.setNumeroCel(dto.getNumeroCel());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(voluntario, dto.getIdAbrigo()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> editar(@PathVariable Integer id, @Valid @RequestBody VoluntarioDTO dto) {
        return service.buscarPorId(id)
                .map((old) -> {
                    old.setCpf(dto.getCpf());
                    old.setNome(dto.getNome());
                    old.setDdd(dto.getDdd());
                    old.setNumeroCel(dto.getNumeroCel());
                    return ResponseEntity.ok(service.salvar(old, dto.getIdAbrigo()));
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