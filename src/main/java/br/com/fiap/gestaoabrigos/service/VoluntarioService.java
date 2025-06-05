package br.com.fiap.gestaoabrigos.service;

import br.com.fiap.gestaoabrigos.model.Abrigo;
import br.com.fiap.gestaoabrigos.model.Voluntario;
import br.com.fiap.gestaoabrigos.repository.AbrigoRepository;
import br.com.fiap.gestaoabrigos.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository repository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    public Page<Voluntario> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Voluntario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Voluntario salvar(Voluntario voluntario, Integer idAbrigo) {
        Abrigo abrigo = abrigoRepository.findById(idAbrigo).orElseThrow(
                () -> new IllegalArgumentException("Abrigo não encontrado")
        );
        voluntario.setAbrigo(abrigo);
        return repository.save(voluntario);
    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }
}