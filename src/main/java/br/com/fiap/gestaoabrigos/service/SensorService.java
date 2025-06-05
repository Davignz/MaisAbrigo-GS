package br.com.fiap.gestaoabrigos.service;

import br.com.fiap.gestaoabrigos.model.Abrigo;
import br.com.fiap.gestaoabrigos.model.Sensor;
import br.com.fiap.gestaoabrigos.repository.SensorRepository;
import br.com.fiap.gestaoabrigos.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    public Page<Sensor> listar(Pageable pageable) {
        return sensorRepository.findAll(pageable);
    }

    public Optional<Sensor> buscarPorId(Integer id) {
        return sensorRepository.findById(id);
    }

    public Sensor salvar(Sensor sensor, Integer idAbrigo) {
        Abrigo abrigo = abrigoRepository.findById(idAbrigo)
                .orElseThrow(() -> new IllegalArgumentException("Abrigo não encontrado"));
        sensor.setAbrigo(abrigo);
        return sensorRepository.save(sensor);
    }

    public void remover(Integer id) {
        sensorRepository.deleteById(id);
    }
}