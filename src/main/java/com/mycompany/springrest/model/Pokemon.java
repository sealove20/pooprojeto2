package com.mycompany.springrest.model;

public class Pokemon {
    private long id;
    private String nome;
    private long cp;
    private long hp;
    private long doce;
    private String tipo;

    public Pokemon(){}

    public Pokemon(long id, String nome, long cp, long hp, long doce, String tipo) {
        this.id = id;
        this.nome = nome;
        this.cp = cp;
        this.hp = hp;
        this.doce = doce;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCp() {
        return cp;
    }

    public void setCp(long cp) {
        this.cp = cp;
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public long getDoce() {
        return doce;
    }

    public void setDoce(long doce) {
        this.doce = doce;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
