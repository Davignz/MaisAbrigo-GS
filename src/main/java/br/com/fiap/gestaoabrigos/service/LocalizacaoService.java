package br.com.fiap.gestaoabrigos.service;

import br.com.fiap.gestaoabrigos.model.Localizacao;
import br.com.fiap.gestaoabrigos.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalizacaoService {
    @Autowired
    private LocalizacaoRepository repository;

    public Page<Localizacao> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Localizacao> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Localizacao salvar(Localizacao localizacao) {
        return repository.save(localizacao);
    }

    public void remover(Integer id) { repository.deleteById(id); }
}