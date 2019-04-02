package com.mycompany.springrest.files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

//import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.mycompany.springrest.model.Pokemon;
import com.mycompany.springrest.model.Treinador;


public class JsonArquivoStrategy implements ArquivoStrategy {
    //pokemons
    @Override
    public void gerarArquivo(ArrayList<Pokemon> pokes, String caminhoArquivo) {
        JSONArray listaPokemons = new JSONArray();

        pokes.forEach( (Pokemon p) -> {
            JSONObject o = new JSONObject();
            o.put("id", p.getId());
            o.put("nome", p.getNome());
            o.put("cp", p.getCp());
            o.put("hp", p.getHp());
            o.put("doce", p.getDoce());
            o.put("tipo", p.getTipo());
            listaPokemons.add(o);
        });
        try {
            OutputStream outputStream = new FileOutputStream(caminhoArquivo);
            Writer out = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            out.write(listaPokemons.toJSONString());
            out.close();
        }
        catch(FileNotFoundException e) {
            System.err.printf(e.getMessage());
        } catch (IOException e) {
            System.err.printf(e.getMessage());
        }

    }

    @Override
    public ArrayList<Pokemon> lerArquivo(ArrayList<Pokemon> pokes, String caminhoArquivo) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(caminhoArquivo)); // Lê o arquivo json
            JSONArray arrayDePokemons = (JSONArray) obj; // transforma a string em formato ARRAY de JSON

            // itemDoArrayDePokemon é do tipo JSONArray
            arrayDePokemons.forEach(itemDoArrayDePokemon -> {
                /* aqui eu transformei ele para JSONObject, se não fizer o cast aqui, cada item do array
                vai ser tratado como um JSONArray daí não vai ter acesso aos métodos pra pegar cada campo do obj */
                JSONObject pokemon = (JSONObject) itemDoArrayDePokemon;
                long id = (long) pokemon.get("id");
                String nome = (String) pokemon.get("nome");
                long cp = (long) pokemon.get("cp");
                long hp = (long) pokemon.get("hp");
                long doce = (long) pokemon.get("doce");
                String tipo = (String) pokemon.get("tipo");
                pokes.add(new Pokemon(id, nome, cp, hp, doce, tipo));
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pokes;
    }
    //treinadores
    @Override
    public void gerarArquivoTreinador(ArrayList<Treinador> treinadores, String caminhoArquivo) {
        JSONArray listaTreinadores = new JSONArray();

        treinadores.forEach( (Treinador t) -> {
            JSONObject o = new JSONObject();
            o.put("id", t.getId());
            o.put("nome", t.getNome());
            o.put("nivel", t.getNivel());
            o.put("time", t.getTime());

            JSONArray pokemonsTreinador = new JSONArray();
            t.getPokemons().forEach((Pokemon p)->{
                JSONObject opt = new JSONObject();
                opt.put("pokemons",p);
                pokemonsTreinador.add(opt);
            });

            o.put("pokemons", pokemonsTreinador);

            listaTreinadores.add(o);
        });
        try {
            OutputStream outputStream = new FileOutputStream(caminhoArquivo);
            Writer out = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            out.write(listaTreinadores.toJSONString());
            out.close();
        }
        catch(FileNotFoundException e) {
            System.err.printf(e.getMessage());
        } catch (IOException e) {
            System.err.printf(e.getMessage());
        }

    }

    @Override
    public ArrayList<Treinador> lerArquivoTreinador(ArrayList<Treinador> treinadores, String caminhoArquivo) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(caminhoArquivo)); // Lê o arquivo json
            JSONArray arrayDeTreinadores = (JSONArray) obj; // transforma a string em formato ARRAY de JSON

            // itemDoArrayDePokemon é do tipo JSONArray
            arrayDeTreinadores.forEach(itemDoArrayDeTreinador -> {
                /* aqui eu transformei ele para JSONObject, se não fizer o cast aqui, cada item do array
                vai ser tratado como um JSONArray daí não vai ter acesso aos métodos pra pegar cada campo do obj */
                JSONObject treinador = (JSONObject) itemDoArrayDeTreinador;
                long id = (long) treinador.get("id");
                String nome = (String) treinador.get("nome");
                long nivel = (long) treinador.get("nivel");
                String time = (String) treinador.get("time");

//                ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) treinador.get("pokemons");

                Treinador t = new Treinador(id, nome, nivel, time);
//                t.setPokemons(pokemons);
                treinadores.add(t);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return treinadores;
    }
}
