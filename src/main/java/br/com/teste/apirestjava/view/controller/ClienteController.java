package br.com.teste.apirestjava.view.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.apirestjava.model.Cliente;
// import br.com.teste.apirestjava.model.exception.ResourceBadRequestException;
import br.com.teste.apirestjava.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obterTodos() {
        return clienteService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obterPeloId(@PathVariable Integer id) {

        return clienteService.obterPeloId(id);
    }

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {

        return clienteService.cadastrar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {

      
        return clienteService.atualizar(id, cliente);
        
    }

    @DeleteMapping("/{id}")
    public String deletar(Integer id) {

        clienteService.deletar(id);

        return "Cliente deletado com sucesso.";
    }
}
