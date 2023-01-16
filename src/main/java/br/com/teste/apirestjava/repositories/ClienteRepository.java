package br.com.teste.apirestjava.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Cliente> obterPeloId(Integer id) {

        return Clientes.stream().filter(c -> c.getId() == id).findFirst();
    }

    /**
     * Método que cadastra um cliente na base de dados
     * @param cliente cliente a ser cadastrado
     * @return retorna o cliente cadatrado
     */

    public Cliente cadastrar(Cliente cliente) {

        ultimoId++;
        cliente.setId(ultimoId);

        Clientes.add(cliente);

        return cliente;
    }

    public void deletar(Integer id){

        Clientes.removeIf(c -> c.getId() == id);

    }
}
