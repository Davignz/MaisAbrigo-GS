package br.com.fiap.gestaoabrigos.service;

import br.com.fiap.gestaoabrigos.model.Abrigo;
import br.com.fiap.gestaoabrigos.model.Localizacao;
import br.com.fiap.gestaoabrigos.repository.AbrigoRepository;
import br.com.fiap.gestaoabrigos.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AbrigoService {
    @Autowired
    private AbrigoRepository repository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public Page<Abrigo> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Abrigo> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Abrigo salvar(Abrigo abrigo, Integer idLocal) {
        Localizacao localizacao = localizacaoRepository.findById(idLocal)
                .orElseThrow(() -> new IllegalArgumentException("Localização não encontrada"));
        abrigo.setLocalizacao(localizacao);
        return repository.save(abrigo);
    }

    public void remover(Integer id) { repository.deleteById(id); }
}