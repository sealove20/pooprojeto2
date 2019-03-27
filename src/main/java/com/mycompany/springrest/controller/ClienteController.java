package com.mycompany.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.mycompany.springrest.dao.ClienteDAO;
import com.mycompany.springrest.model.Cliente;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
 
@RestController
@RequestMapping(path = "/clientes")
public class ClienteController
{
    @Autowired
    private ClienteDAO clienteDao;
     
    //@GetMapping(path="/", produces = "application/json")
    @RequestMapping(value = {"/",""}, method = RequestMethod.GET, 
            produces = "application/json")
    public List<Cliente> getClientes()
    {
        return clienteDao.getClientes();
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, 
            produces = "application/json")
    public Cliente getCliente(@PathVariable("id") int id)
    { 
        for (Cliente c: clienteDao.getClientes())
            if (c.getId()==id)
                return c;
        
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Cliente nao encontrado");
    }    
     
    
    //@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    @RequestMapping(value = {"/",""}, method = RequestMethod.POST, 
            produces = "application/json")
    public Cliente addCliente(@RequestBody Cliente cliente)
    {
        Integer id = clienteDao.getClientes().size();
        cliente.setId(id);
         
        clienteDao.addCliente(cliente);
         
        return cliente;
        
        // Para testar: 
        // curl -d '{"nome":"joao sampaio", "idade": 90, "endereco": 
        //     "endereco do joao", "cidade": "cidade do joao"}' 
        //     -H "Content-Type: application/json" 
        //     -X POST http://localhost:8090/clientes/
        
    }
}


