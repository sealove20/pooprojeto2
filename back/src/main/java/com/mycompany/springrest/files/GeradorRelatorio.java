package com.mycompany.springrest.files;

import java.util.ArrayList;
import com.mycompany.springrest.model.Pokemon;

public class GeradorRelatorio {

    private ArquivoStrategy strategy;

    public GeradorRelatorio(ArquivoStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void gerar(ArrayList<Pokemon> pokes, String caminhoArquivo) {
        this.strategy.gerarArquivo(pokes, caminhoArquivo);
    }

    public ArrayList<Pokemon> ler(ArrayList<Pokemon> pokes, String caminhoArquivo) {
        return this.strategy.lerArquivo(pokes, caminhoArquivo);
    }
}
