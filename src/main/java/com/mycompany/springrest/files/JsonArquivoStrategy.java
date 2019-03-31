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


public class JsonArquivoStrategy implements ArquivoStrategy {

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
            JSONArray jsonObject = (JSONArray) obj; // transforma a string em formato JSON

            // garimpa os dados do json
            jsonObject.forEach(o -> {
                JSONObject a = (JSONObject) o;
                long id = (long) a.get("id");
                String nome = (String) a.get("nome");
                long cp = (long) a.get("cp");
                long hp = (long) a.get("hp");
                long doce = (long) a.get("doce");
                String tipo = (String) a.get("tipo");
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

}
