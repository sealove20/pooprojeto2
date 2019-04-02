package com.mycompany.springrest.model;

import java.util.ArrayList;

public class Treinador {

    private long id;
    private String nome;
    private long nivel;
    private String time;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public Treinador(){}

    public Treinador(long id, String nome, long nivel, String time) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
