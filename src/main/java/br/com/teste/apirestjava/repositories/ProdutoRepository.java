package br.com.teste.apirestjava.repositories;

import java.util.ArrayList;
import java.util.List;

/**
 * é uma classe criada p/ retornar algo nulo caso não 
 * retorne o que é esperado. 
 * Isso evita a ocorrencia de erro caso o retorno esperado nao seja encontrado.
 */
import java.util.Optional;


import org.springframework.stereotype.Repository;

import br.com.teste.apirestjava.model.Produto;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de produtos
     * @return lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo Id
     * @param id do produto que será localizado
     * @return um produto
     */
    public Optional<Produto> obterPorId(Integer id){

        return produtos.stream().filter(p -> p.getId() == id).findFirst();
    }

}
