package br.com.fiap.gestaoabrigos.repository;

import br.com.fiap.gestaoabrigos.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {
}