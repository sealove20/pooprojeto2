package com.mycompany.springrest.model;

public class Pokemon {

    private String nome;
    private int cp;
    private int hp;
    private int doce;
    private String tipo;

    public Pokemon(){
    }

    public Pokemon(String nome, int cp, int hp, int doce, String tipo) {
        this.nome = nome;
        this.cp = cp;
        this.hp = hp;
        this.doce = doce;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDoce() {
        return doce;
    }

    public void setDoce(int doce) {
        this.doce = doce;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
