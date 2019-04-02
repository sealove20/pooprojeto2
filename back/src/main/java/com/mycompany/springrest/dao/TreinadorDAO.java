package com.mycompany.springrest.dao;

import com.mycompany.springrest.files.GeradorRelatorio;
import com.mycompany.springrest.files.JsonArquivoStrategy;
import com.mycompany.springrest.model.Treinador;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TreinadorDAO {
    private final ArrayList<Treinador> treinadores = new ArrayList<>();
    private GeradorRelatorio g = new GeradorRelatorio(new JsonArquivoStrategy());
    TreinadorDAO(){
        g.lerTreinador(treinadores, "treinadores.json");
    }

    public List<Treinador> getTreinadores() {
        return treinadores;
    }

    public void addTreinador(Treinador t) {
        treinadores.add(t);
        g.gerarTreinador(treinadores, "treinadores.json");
    }

    public void deletarTreinador(Treinador t){
        treinadores.remove(t);
        g.gerarTreinador(treinadores, "treinadores.json");
    }

}
