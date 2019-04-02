package com.mycompany.springrest.files;

import java.util.ArrayList;
import com.mycompany.springrest.model.Pokemon;
import com.mycompany.springrest.model.Treinador;

public interface ArquivoStrategy {
    void gerarArquivo(ArrayList<Pokemon> pokes, String caminhoArquivo);
    ArrayList<Pokemon> lerArquivo(ArrayList<Pokemon> pokes, String caminhoArquivo);

    void gerarArquivoTreinador(ArrayList<Treinador> treinadores, String caminhoArquivo);
    ArrayList<Treinador> lerArquivoTreinador(ArrayList<Treinador> treinadores, String caminhoArquivo);
}
