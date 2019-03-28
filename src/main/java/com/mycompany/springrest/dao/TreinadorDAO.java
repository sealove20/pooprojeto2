package com.mycompany.springrest.dao;

import com.mycompany.springrest.model.Treinador;

import java.util.ArrayList;
import java.util.List;

public class TreinadorDAO {

    private final ArrayList<Treinador> treinadores = new ArrayList<>();

    TreinadorDAO(){
        treinadores.add(new Treinador("Roger", 28, "Amarelo"));
        treinadores.add(new Treinador("Cleyton", 25, "Azul"));
        treinadores.add(new Treinador("Maikon", 40, "Vermelho"));
        treinadores.add(new Treinador("Clóvis", 40, "Vermelho"));
    }

    public static void cadastrarTreinador(){

    }

    public List<Treinador> getClientes() {
        return treinadores;
    }

    public void addTreinador(Treinador t) {
        treinadores.add(t);
    }

}
