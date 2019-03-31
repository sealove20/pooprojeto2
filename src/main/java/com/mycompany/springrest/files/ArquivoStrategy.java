package com.mycompany.springrest.files;

import java.util.ArrayList;
import com.mycompany.springrest.model.Pokemon;

public interface ArquivoStrategy {
    void gerarArquivo(ArrayList<Pokemon> pokes, String caminhoArquivo);
    ArrayList<Pokemon> lerArquivo(ArrayList<Pokemon> pokes, String caminhoArquivo);
}
