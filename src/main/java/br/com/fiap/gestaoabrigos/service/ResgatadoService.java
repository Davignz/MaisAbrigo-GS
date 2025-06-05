package br.com.fiap.gestaoabrigos.service;

import br.com.fiap.gestaoabrigos.model.Abrigo;
import br.com.fiap.gestaoabrigos.model.Evento;
import br.com.fiap.gestaoabrigos.model.Resgatado;
import br.com.fiap.gestaoabrigos.repository.AbrigoRepository;
import br.com.fiap.gestaoabrigos.repository.EventoRepository;
import br.com.fiap.gestaoabrigos.repository.ResgatadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResgatadoService {

    @Autowired
    private ResgatadoRepository resgatadoRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public Page<Resgatado> listar(Pageable pageable) {
        return resgatadoRepository.findAll(pageable);
    }

    public Optional<Resgatado> buscarPorId(Integer id) {
        return resgatadoRepository.findById(id);
    }

    public Resgatado salvar(Resgatado resgatado, Integer idAbrigo, Integer idEvento) {
        Abrigo abrigo = abrigoRepository.findById(idAbrigo).orElseThrow(() -> new IllegalArgumentException("Abrigo não encontrado"));
        Evento evento = eventoRepository.findById(idEvento).orElseThrow(() -> new IllegalArgumentException("Evento não encontrado"));
        resgatado.setAbrigo(abrigo);
        resgatado.setEvento(evento);
        return resgatadoRepository.save(resgatado);
    }

    public void remover(Integer id) {
        resgatadoRepository.deleteById(id);
    }
}