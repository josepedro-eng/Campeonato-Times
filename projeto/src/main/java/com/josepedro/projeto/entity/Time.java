package com.josepedro.projeto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "times")

public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cidade;
    private String estadio;

    public Time(){

    }
    public Long getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getEstadio(){
        return estadio;
    }

    public void setEstadio(String estadio){
        this.estadio = estadio;
    }

}
