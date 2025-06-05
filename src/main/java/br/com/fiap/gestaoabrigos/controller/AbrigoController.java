package br.com.fiap.gestaoabrigos.controller;

import br.com.fiap.gestaoabrigos.model.Abrigo;
import br.com.fiap.gestaoabrigos.dto.AbrigoDTO;
import br.com.fiap.gestaoabrigos.service.AbrigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {
    @Autowired
    private AbrigoService service;

    @GetMapping
    public Page<Abrigo> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abrigo> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Abrigo> salvar(@Valid @RequestBody AbrigoDTO dto) {
        Abrigo abrigo = new Abrigo();
        abrigo.setId(dto.getId());
        abrigo.setNome(dto.getNome());
        abrigo.setCapacidade(dto.getCapacidade());
        abrigo.setOcupacao(dto.getOcupacao());
        abrigo.setQtdAgua(dto.getQtdAgua());
        abrigo.setQtdRoupa(dto.getQtdRoupa());
        abrigo.setComidaPorPessoa(dto.getComidaPorPessoa());
        abrigo.setQtdDormitorio(dto.getQtdDormitorio());

        return ResponseEntity.status(HttpStatus.CREATED).body(
                service.salvar(abrigo, dto.getIdLocal())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abrigo> editar(@PathVariable Integer id, @Valid @RequestBody AbrigoDTO dto) {
        return service.buscarPorId(id).map((old) -> {
            old.setNome(dto.getNome());
            old.setCapacidade(dto.getCapacidade());
            old.setOcupacao(dto.getOcupacao());
            old.setQtdAgua(dto.getQtdAgua());
            old.setQtdRoupa(dto.getQtdRoupa());
            old.setComidaPorPessoa(dto.getComidaPorPessoa());
            old.setQtdDormitorio(dto.getQtdDormitorio());
            return ResponseEntity.ok(service.salvar(old, dto.getIdLocal()));
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