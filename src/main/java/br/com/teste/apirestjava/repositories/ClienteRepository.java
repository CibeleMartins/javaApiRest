package br.com.teste.apirestjava.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.teste.apirestjava.model.Cliente;

@Repository
public class ClienteRepository {
    
    private List<Cliente> Clientes = new ArrayList<Cliente>();
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de Clientes
     * 
     * @return lista de Clientes
     */
    public List<Cliente> obterTodos() {
        return Clientes;
    }
}
