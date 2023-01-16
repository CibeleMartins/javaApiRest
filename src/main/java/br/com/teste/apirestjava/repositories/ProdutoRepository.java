package br.com.teste.apirestjava.repositories;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

    // Simula o banco de dados
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de produtos
     * 
     * @return lista de produtos
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo Id
     * 
     * @param id do produto que será localizado
     * @return retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {

        return produtos.stream().filter(p -> p.getId() == id).findFirst();
    }

    /**
     * Método para adicionar produto na lista.
     * 
     * @param produto produto que será adicionado a lista.
     * @return retorna o produto que foi adicionado na lista.
     */
    public Produto cadastrar(Produto produto) {

        ultimoId++;
        // incrementa o id
        produto.setId(ultimoId);
        // passa o id pro produto
        produtos.add(produto);
        // passa pra lista que simula o BD

        return produto;
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto produto que será atualizado.
     * @return retorna o produto após atualizar a lista.
     */

    public Produto atualizar(Produto produto) {

        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        // encontrar produto na lista.

        if (produtoEncontrado.isEmpty()) {
            throw new InputMismatchException("Produto não encontrado.");
        }

        // Remover o produto antigo da lista
        deletar(produto.getId());

        // Adicionar um novo produto.
        // n foi utilizado o método cadastrar p/ n mudar o id, que no método cadastral é
        // incremental.
        produtos.add(produto);

        return produto;
    }

    /**
     * Método que deleta o produto pelo id.
     * 
     * @param id do produto a ser deletado.
     */

    public void deletar(Integer id) {
        // void é o tipo de método que nao tem retorno

        produtos.removeIf(p -> p.getId() == id);
        // um método que remove de dentro de uma lista de acordo com um filtro/condicao
        // passado.
     

    }

}
