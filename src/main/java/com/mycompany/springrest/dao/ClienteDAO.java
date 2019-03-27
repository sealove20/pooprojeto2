package com.mycompany.springrest.dao;

import com.mycompany.springrest.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO {
    
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    
    ClienteDAO(){
        clientes.add(new Cliente(0, "Joao da Silva", "Rua Parana", "Foz", 45));
        clientes.add(new Cliente(1, "Mauricio", "Rua Pingo", "Cascavel", 15));
        clientes.add(new Cliente(2, "Marcelo", "Rua Gaitaco", "Joinville", 25));
        clientes.add(new Cliente(3, "Tertulio", "Av. dos Pampas", "Porto Alegre", 27));
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public void addCliente(Cliente c) {
        clientes.add(c);
    }    
    
}
