package br.com.teste.apirestjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.apirestjava.model.Produto;
import br.com.teste.apirestjava.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    // devolve uma instancia pronta do repositorio do produto sem precisar
    // instanciar.
    private ProdutoRepository produtoRepository;

    /**
     * Método que aciona o repositório para obter todos os produtos.
     * @return retorna uma lista de produtos.
     */
    public List<Produto> obterTodos() {

        return produtoRepository.obterTodos();
    }
}
