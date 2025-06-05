package br.com.fiap.gestaoabrigos.controller;

import br.com.fiap.gestaoabrigos.model.Localizacao;
import br.com.fiap.gestaoabrigos.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {
    @Autowired
    private LocalizacaoService service;

    @GetMapping
    public Page<Localizacao> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localizacao> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Localizacao> salvar(@Valid @RequestBody Localizacao localizacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(localizacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Localizacao> editar(@PathVariable Integer id, @Valid @RequestBody Localizacao novo) {
        return service.buscarPorId(id)
                .map(localizacao -> {
                    novo.setId(id);
                    return ResponseEntity.ok(service.salvar(novo));
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