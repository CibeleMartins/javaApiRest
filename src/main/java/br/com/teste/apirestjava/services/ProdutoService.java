package br.com.teste.apirestjava.services;

import java.util.List;
import java.util.Optional;

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

        return produtoRepository.findAll();
    }

    /**
     * Método que aciona o repositório para obter um produto pelo id.
     * @return retorna o produto encontrado pelo id.
     */
    public Optional<Produto> obterPorId(Integer id) {

        return produtoRepository.findById(id);
    }

    /**
     * Método que aciona o repositório para cadatrar um produto.
     * @return retorna o produto cadastrado.
     */
    public Produto cadastrar(Produto produto) {
        // Poderia ter alguma regra de negocio para adicionar um produto aqui.
        // Ex: obrigatório passar o nome do produto, ou um valor acima de 100
        produto.setId(null);
       return produtoRepository.save(produto);
    }

    public void deletar(Integer id) {
        // Poderia ter alguma lógica de validação
        // Ex: ver se o usuário tem permissão para deletar.
        
        produtoRepository.deleteById(id);
    }

    public Produto atualizar(Integer id, Produto produto) {

      produto.setId(id);

      return produtoRepository.save(produto);
    }

}
