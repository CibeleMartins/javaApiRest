package br.com.teste.apirestjava.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import br.com.teste.apirestjava.model.Cliente;
// import br.com.teste.apirestjava.model.exception.ResourceBadRequestException;
import br.com.teste.apirestjava.services.ClienteService;
import br.com.teste.apirestjava.shared.ClienteDTO;
import br.com.teste.apirestjava.view.model.ClienteRequest;
import br.com.teste.apirestjava.view.model.ClienteResponse;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obterTodos() {

        List<ClienteDTO> clientesDtos = clienteService.obterTodos();

        List<ClienteResponse> clientesResp = clientesDtos.stream()
                .map(c -> new ModelMapper().map(clientesDtos, ClienteResponse.class)).collect(Collectors.toList());
        
        return new ResponseEntity<List<ClienteResponse>>(clientesResp, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteResponse>> obterPeloId(@PathVariable Integer id) {

       Optional<ClienteDTO> clienteDto = clienteService.obterPeloId(id);

       ClienteResponse clienteResp = new ModelMapper().map(clienteDto.get(), ClienteResponse.class);

       return new ResponseEntity<>(Optional.of(clienteResp), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody ClienteRequest clienteReq) {

        ModelMapper mapper = new ModelMapper();
        ClienteDTO clienteDto = mapper.map(clienteReq, ClienteDTO.class);

        clienteDto = clienteService.cadastrar(clienteDto);

        ClienteResponse clienteResp = mapper.map(clienteDto, ClienteResponse.class);

        return new ResponseEntity<>(clienteResp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Integer id, @RequestBody ClienteRequest clienteReq) {


        ClienteDTO clienteDto = new ModelMapper().map(clienteReq, ClienteDTO.class);

        clienteDto = clienteService.atualizar(id, clienteDto);

        ClienteResponse clienteResp = new ModelMapper().map(clienteDto, ClienteResponse.class);

        return new ResponseEntity<>(clienteResp, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {

        clienteService.deletar(id);

        return new ResponseEntity<>("Cliente de id -> " + id + " deletado com sucesso.", HttpStatus.OK);
    }
}
