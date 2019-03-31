package com.mycompany.springrest.dao;

import com.mycompany.springrest.files.JsonArquivoStrategy;
import com.mycompany.springrest.model.Pokemon;
import com.mycompany.springrest.files.GeradorRelatorio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonDAO {
    private final ArrayList<Pokemon> pokemons = new ArrayList<>();
    private GeradorRelatorio g = new GeradorRelatorio(new JsonArquivoStrategy());
    PokemonDAO(){
            g.ler(pokemons, "pokemons.json");
//        pokemons.add(new Pokemon(0,"Agumon", 1000, 500, 10, "Grama"));
//        pokemons.add(new Pokemon(1,"Patamon", 200, 100, 300, "Voador"));
//        pokemons.add(new Pokemon(2,"Ninjamon", 1500, 700, 210, "Lutador"));
//        pokemons.add(new Pokemon(3,"Karatemon", 2567, 1500, 110, "Safadao"));
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon t) {
        pokemons.add(t);
        g.gerar(pokemons, "pokemons.json");
    }
    
    //deletar pokemon - recebe um pokemon e o deleta
    public void deletarPokemon(Pokemon p){
        pokemons.remove(p);
        g.gerar(pokemons, "pokemons.json");
    }

}
