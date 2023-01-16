package br.com.teste.apirestjava.repositories;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

    /**
     * Método que acessa um cliente pelo id.
     * @param id id do cliente a ser acessado.
     * @return retorna o cliente com o id indicado no parametro.
     */
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

    /**
     * Método que atualiza um cliente na base de dados.
     * @param cliente cliente a ser atualizado.
     * @return retorna o cliente atualizado.
     */
    public Cliente atualizar(Cliente cliente) {

        Optional<Cliente> clienteEncontrado = obterPeloId(cliente.getId());

        if (clienteEncontrado.isEmpty()) {

            throw new InputMismatchException("Cliente não encontrado.");
        }

        deletar(cliente.getId());

        Clientes.add(cliente);

        return cliente;

    }

    /**
     * Método que deleta cliente da base da dados.
     * @param id id do cliente a ser deletado.
     */
    public void deletar(Integer id){

        Clientes.removeIf(c -> c.getId() == id);

    }
}
