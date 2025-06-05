package br.com.fiap.gestaoabrigos.repository;

import br.com.fiap.gestaoabrigos.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}