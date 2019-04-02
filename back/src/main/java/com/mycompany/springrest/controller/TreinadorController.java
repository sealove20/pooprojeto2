package com.mycompany.springrest.controller;

import com.mycompany.springrest.dao.TreinadorDAO;
import com.mycompany.springrest.model.Treinador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springrest.dao.TreinadorDAO;
import com.mycompany.springrest.model.Treinador;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/treinadores")
public class TreinadorController {
    @Autowired
    private TreinadorDAO treinadorDAO;

    //@GetMapping(path="/", produces = "application/json")
    @RequestMapping(value = {"/",""}, method = RequestMethod.GET, produces = "application/json")
    public List<Treinador> getTreinadores(){
        return treinadorDAO.getTreinadores();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Treinador getTreinador(@PathVariable("id") int id) {
        for (Treinador t: treinadorDAO.getTreinadores())
            if (t.getId()==id)
                return t;

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Treinador não encontrado");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public List<Treinador> deletarTreinador(@PathVariable("id") int id) {
        for (Treinador t: treinadorDAO.getTreinadores())
            if (t.getId()==id){
                treinadorDAO.deletarTreinador(t);
                return treinadorDAO.getTreinadores();
            }


        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Treinador com o ID "+id+" não encontrado!");
    }

    //@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    @RequestMapping(value = {"/",""}, method = RequestMethod.POST, produces = "application/json")
    public Treinador addTreinador(@RequestBody Treinador treinador) {
        Integer id = treinadorDAO.getTreinadores().size();
        treinador.setId(id);

        treinadorDAO.addTreinador(treinador);

        return treinador;
    }
}


