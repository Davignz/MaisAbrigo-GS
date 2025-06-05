package br.com.fiap.gestaoabrigos.repository;

import br.com.fiap.gestaoabrigos.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {
}