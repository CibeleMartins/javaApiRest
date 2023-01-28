package br.com.teste.apirestjava.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.apirestjava.repositories.ClienteRepository;
import br.com.teste.apirestjava.shared.ClienteDTO;
import br.com.teste.apirestjava.model.Cliente;
import br.com.teste.apirestjava.model.exception.ResourceNotFoundException;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    /**
     * Método para retornar uma lista de Clientes
     * 
     * @return lista de Clientes
     */
    public List<ClienteDTO> obterTodos() {

        List<Cliente> clientes = clienteRepository.findAll();

        System.out.print(clientes);

        List<ClienteDTO> clientesDto = clientes.stream().map(c -> new ModelMapper().map(c, ClienteDTO.class)).collect(Collectors.toList());

        return clientesDto;
        
    }

    /**
     * Método que acessa um cliente pelo Id no repositório.
     * 
     * @param cliente cliente a ser cadastrado
     * @return retorna o cliente cadatrado
     */
    public Optional<ClienteDTO> obterPeloId(Integer id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isEmpty()) {
            throw new ResourceNotFoundException("Cliente não encontrado. Id -> " + id);
        }

        ModelMapper mapper = new ModelMapper();

        ClienteDTO clienteDto = mapper.map(cliente.get(), ClienteDTO.class);

        return Optional.of(clienteDto);
    }

    /**
     * Método que aciona o cadastro do cliente no repositório.
     * 
     * @param cliente cliente a ser cadastrado
     * @return retorna o cliente cadatrado
     */
    public ClienteDTO cadastrar(ClienteDTO clienteDto) {

        clienteDto.setId(null);
        Cliente cliente = new ModelMapper().map(clienteDto, Cliente.class);


       cliente = clienteRepository.save(cliente);

       clienteDto.setId(cliente.getId());

       return clienteDto;
    }

    /**
     * Método que aciona a atualização do cliente no repositório.
     * 
     * @param cliente cliente a ser atualizado.
     * @return retorna o cliente atualizado.
     */
    public ClienteDTO atualizar(Integer id, ClienteDTO clienteDto) {

        ModelMapper mapper = new ModelMapper();

        clienteDto.setId(id);

        Cliente cliente = mapper.map(clienteDto, Cliente.class);

        clienteRepository.save(cliente);

        return clienteDto;
    }

    /**
     * Método que aciona um cliente a ser deletado no repositório.
     * 
     * @param id id do cliente a ser deletado.
     */
    public String deletar(Integer id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isEmpty()) {
            throw new ResourceNotFoundException("Não é possível deletar o produto de id:  " + id + " porque ele não existe.");
        }

        clienteRepository.deleteById(id);

        return "Cliente deletado com sucesso.";
    }

}