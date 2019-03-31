package com.mycompany.springrest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springrest.dao.PokemonDAO;
import com.mycompany.springrest.model.Pokemon;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/pokemons")
public class PokemonController
{
    @Autowired
    private PokemonDAO pokemonDAO;

    //@GetMapping(path="/", produces = "application/json")
    @RequestMapping(value = {"/",""}, method = RequestMethod.GET,
            produces = "application/json")
    public List<Pokemon> getPokemons(){ return pokemonDAO.getPokemons(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = "application/json")
    public Pokemon getPokemon(@PathVariable("id") int id)
    {
        for (Pokemon p: pokemonDAO.getPokemons())
            if (p.getId()==id)
                return p;

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Pokemon não encontrado");
    }


    //@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    @RequestMapping(value = {"/",""}, method = RequestMethod.POST,
            produces = "application/json")
    public Pokemon addPokemon(@RequestBody Pokemon pokemon)
    {
        Integer id = pokemonDAO.getPokemons().size();
        pokemon.setId(id);

        pokemonDAO.addPokemon(pokemon);

        return pokemon;

        // Para testar:
        // curl -d '{"nome":"joao sampaio", "idade": 90, "endereco":
        //     "endereco do joao", "cidade": "cidade do joao"}'
        //     -H "Content-Type: application/json"
        //     -X POST http://localhost:8090/clientes/

    }
}


