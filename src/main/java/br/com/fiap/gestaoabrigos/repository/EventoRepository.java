package br.com.fiap.gestaoabrigos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.gestaoabrigos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    @Query(value = "SELECT funcao_risco_medio FROM dual", nativeQuery = true)
    Double getRiscoMedio();
}