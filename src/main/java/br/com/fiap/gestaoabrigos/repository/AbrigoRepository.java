package br.com.fiap.gestaoabrigos.repository;

import br.com.fiap.gestaoabrigos.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbrigoRepository extends JpaRepository<Abrigo, Integer> {
}