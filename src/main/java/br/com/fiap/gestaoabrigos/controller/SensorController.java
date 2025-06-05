package br.com.fiap.gestaoabrigos.controller;

import br.com.fiap.gestaoabrigos.dto.SensorDTO;
import br.com.fiap.gestaoabrigos.model.Sensor;
import br.com.fiap.gestaoabrigos.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sensores")
public class SensorController {
    @Autowired
    private SensorService service;

    @GetMapping
    public Page<Sensor> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sensor> salvar(@Valid @RequestBody SensorDTO dto) {
        Sensor sensor = new Sensor();
        sensor.setId(dto.getId());
        sensor.setValorLido(dto.getValorLido());
        sensor.setDataHora(dto.getDataHora());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(sensor, dto.getIdAbrigo()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> editar(@PathVariable Integer id, @Valid @RequestBody SensorDTO dto) {
        return service.buscarPorId(id)
                .map((old) -> {
                    old.setValorLido(dto.getValorLido());
                    old.setDataHora(dto.getDataHora());
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