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

import br.com.teste.apirestjava.model.Produto;
import br.com.teste.apirestjava.services.ProdutoService;
import br.com.teste.apirestjava.shared.ProdutoDTO;
import br.com.teste.apirestjava.view.model.ProdutoRequest;
import br.com.teste.apirestjava.view.model.ProdutoResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterTodos() {

        // converter a lista de dto em lista re produto response
        List<ProdutoDTO> produtoDto = produtoService.obterTodos();

        ModelMapper mapper = new ModelMapper();

        List<ProdutoResponse> produtoResp = produtoDto.stream()
                .map(pDto -> mapper.map(produtoDto, ProdutoResponse.class)).collect(Collectors.toList());

        // retorna uma resposta c/ um status - uma classe que trabalha com respostas
        return new ResponseEntity<>(produtoResp, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Integer id) {
        // se n tiver exceção usa try catch, se não lança a execeção.
    //    try {
        Optional<ProdutoDTO> dto = produtoService.obterPorId(id);

        ProdutoResponse produto = new ModelMapper().map(dto.get(), ProdutoResponse.class);
        return new ResponseEntity<>(Optional.of(produto), HttpStatus.OK);
    //    } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //    }
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrar(@RequestBody ProdutoRequest produtoReq) {

        ModelMapper mapper = new ModelMapper();

        ProdutoDTO dto = mapper.map(produtoReq, ProdutoDTO.class);
        
        dto = produtoService.cadastrar(dto);

        ProdutoResponse produtoResp = mapper.map(dto, ProdutoResponse.class);

        return new ResponseEntity<>(produtoResp, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {
        produtoService.deletar(id);

        return new ResponseEntity<>("O produto de id: " + id + " não pode ser deletado porque não existe", HttpStatus.NOT_FOUND );
    }
    /**
     * Método que atualiza um produto
     * 
     * @param id      id do produto a ser atualizado
     * @param produto produto a ser atualizado
     * @return retorna o produto atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest produtoReq) {

        ModelMapper mapper = new ModelMapper();

        ProdutoDTO produtoDto = mapper.map(produtoReq, ProdutoDTO.class);

       produtoDto = produtoService.atualizar(id, produtoDto);

         ProdutoResponse produtoResp = mapper.map(produtoDto, ProdutoResponse.class);

        return new ResponseEntity<>(produtoResp, HttpStatus.OK);
    }
}
