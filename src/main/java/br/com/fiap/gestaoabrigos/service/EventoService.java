package br.com.fiap.gestaoabrigos.service;

import br.com.fiap.gestaoabrigos.model.Evento;
import br.com.fiap.gestaoabrigos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public Double riscoMedio(){
        return repository.getRiscoMedio();
    }

    public Page<Evento> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Evento> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Evento salvar(Evento evento) {
        return repository.save(evento);
    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }
}