package br.com.teste.apirestjava.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.teste.apirestjava.view.model.ProdutoResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoResponse> obterTodos() {

        // converter a lista de dto em lista re produto response
        List<ProdutoDTO> produtoDto = produtoService.obterTodos();

        ModelMapper mapper = new ModelMapper();

        List<ProdutoResponse> produtoResp = produtoDto.stream()
                .map(pDto -> mapper.map(produtoDto, ProdutoResponse.class)).collect(Collectors.toList());
        
        return produtoResp;
    }

    @GetMapping("/{id}")
    public Optional<ProdutoResponse> obterPorId(@PathVariable Integer id) {

        return produtoService.obterPorId(id);
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoService.cadastrar(produto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        produtoService.deletar(id);

        return "Produto de id " + id + " foi removido.";
    }

    /**
     * Método que atualiza um produto
     * 
     * @param id      id do produto a ser atualizado
     * @param produto produto a ser atualizado
     * @return retorna o produto atualizado
     */
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Integer id, @RequestBody Produto produto) {

        return produtoService.atualizar(id, produto);
    }
}
