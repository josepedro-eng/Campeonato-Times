package com.josepedro.projeto.controller;

import com.josepedro.projeto.entity.Time;
import com.josepedro.projeto.service.TimeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {
    private final TimeService service;

    public TimeController(TimeService service){
        this.service = service;
    }

    @PostMapping
    public Time criar(@RequestBody Time time){
        return service.salvar(time);
    }

    @GetMapping
    public  List<Time> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Time buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Time atualizar(
            @PathVariable Long id,
            @RequestBody Time time) {
        return service.atualizar(id, time);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
