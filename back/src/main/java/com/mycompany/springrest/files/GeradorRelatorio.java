package com.mycompany.springrest.files;

import java.util.ArrayList;
import com.mycompany.springrest.model.Pokemon;
import com.mycompany.springrest.model.Treinador;

public class GeradorRelatorio {

    private ArquivoStrategy strategy;

    public GeradorRelatorio(ArquivoStrategy strategy) {
        this.strategy = strategy;
    }
    //pokemons
    public void gerar(ArrayList<Pokemon> pokes, String caminhoArquivo) {
        this.strategy.gerarArquivo(pokes, caminhoArquivo);
    }

    public ArrayList<Pokemon> ler(ArrayList<Pokemon> pokes, String caminhoArquivo) {
        return this.strategy.lerArquivo(pokes, caminhoArquivo);
    }
    //treinadores
    public void gerarTreinador(ArrayList<Treinador> treinadores, String caminhoArquivo) {
        this.strategy.gerarArquivoTreinador(treinadores, caminhoArquivo);
    }

    public ArrayList<Treinador> lerTreinador(ArrayList<Treinador> treinadores, String caminhoArquivo) {
        return this.strategy.lerArquivoTreinador(treinadores, caminhoArquivo);
    }
}
