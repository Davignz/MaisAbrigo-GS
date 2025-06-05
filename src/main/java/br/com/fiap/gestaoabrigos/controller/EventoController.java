package br.com.fiap.gestaoabrigos.controller;

import br.com.fiap.gestaoabrigos.model.Evento;
import br.com.fiap.gestaoabrigos.dto.EventoDTO;
import br.com.fiap.gestaoabrigos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping("risco-medio")
    public Double riscoMedio(){
        return service.riscoMedio();
    }

    @GetMapping
    public Page<Evento> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Evento> salvar(@Valid @RequestBody EventoDTO dto) {
        Evento evento = new Evento();
        evento.setId(dto.getId());
        evento.setNome(dto.getNome());
        evento.setDataHora(dto.getDataHora());
        evento.setNivel(dto.getNivel());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(evento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> editar(@PathVariable Integer id, @Valid @RequestBody EventoDTO dto) {
        return service.buscarPorId(id)
                .map((old) -> {
                    old.setNome(dto.getNome());
                    old.setDataHora(dto.getDataHora());
                    old.setNivel(dto.getNivel());
                    return ResponseEntity.ok(service.salvar(old));
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