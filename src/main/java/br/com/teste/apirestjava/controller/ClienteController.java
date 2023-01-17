package br.com.teste.apirestjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.apirestjava.model.Cliente;
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

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {

        return clienteService.cadastrar(cliente);
    }
}
