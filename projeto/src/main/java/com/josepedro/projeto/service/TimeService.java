package com.josepedro.projeto.service;

import com.josepedro.projeto.entity.Time;
import com.josepedro.projeto.repository.TimeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TimeService {
    private final TimeRepository repository;

    public TimeService(TimeRepository repository){
        this.repository = repository;
    }

    public Time salvar(Time time){
        return repository.save(time);
    }

    public List<Time> listar(){
        return repository.findAll();
    }

    public Time buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Time atualizar(Long id, Time timeAtualizado){
        Time timeExistente = repository.findById(id).orElse(null);
        if(timeExistente != null){
            timeExistente.setNome(timeAtualizado.getNome());
            timeExistente.setCidade(timeAtualizado.getCidade());
            timeExistente.setEstadio(timeAtualizado.getEstadio());

            return repository.save(timeExistente);
        }
        return null;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
