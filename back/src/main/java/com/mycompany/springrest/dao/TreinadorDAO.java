package com.mycompany.springrest.dao;

import com.mycompany.springrest.model.Treinador;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TreinadorDAO {

    private final ArrayList<Treinador> treinadores = new ArrayList<>();

    TreinadorDAO(){
        treinadores.add(new Treinador(0,"Roger", 28, "Amarelo"));
        treinadores.add(new Treinador(1,"Cleyton", 25, "Azul"));
        treinadores.add(new Treinador(2,"Maikon", 40, "Vermelho"));
        treinadores.add(new Treinador(3,"Clóvis", 40, "Vermelho"));
    }

    public List<Treinador> getTreinadores() {
        return treinadores;
    }

    public void addTreinador(Treinador t) {
        treinadores.add(t);
    }

}
