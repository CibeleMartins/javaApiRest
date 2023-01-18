package br.com.teste.apirestjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.apirestjava.repositories.ClienteRepository;
import br.com.teste.apirestjava.model.Cliente;
import br.com.teste.apirestjava.model.exception.ResourceBadRequestException;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    /**
     * Método para retornar uma lista de Clientes
     * 
     * @return lista de Clientes
     */
    public List<Cliente> obterTodos() {
        return clienteRepository.obterTodos();
    }

    /**
     * Método que acessa um cliente pelo Id no repositório.
     * 
     * @param cliente cliente a ser cadastrado
     * @return retorna o cliente cadatrado
     */
    public Optional<Cliente> obterPeloId(Integer id) {

        return clienteRepository.obterPeloId(id);
    }

    /**
     * Método que aciona o cadastro do cliente no repositório.
     * 
     * @param cliente cliente a ser cadastrado
     * @return retorna o cliente cadatrado
     */
    public Cliente cadastrar(Cliente cliente) {

        return clienteRepository.cadastrar(cliente);
    }

    /**
     * Método que aciona a atualização do cliente no repositório.
     * 
     * @param cliente cliente a ser atualizado.
     * @return retorna o cliente atualizado.
     */
    public Cliente atualizar(Integer id, Cliente cliente) {


        cliente.setId(id);

        return clienteRepository.atualizar(cliente);

    }

    /**
     * Método que aciona um cliente a ser deletado no repositório.
     * 
     * @param id id do cliente a ser deletado.
     */
    public String deletar(Integer id) {

        clienteRepository.deletar(id);

        return "Cliente deletado com sucesso.";
    }

}