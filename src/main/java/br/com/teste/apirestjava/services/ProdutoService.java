package br.com.teste.apirestjava.services;

// import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.apirestjava.model.Produto;
import br.com.teste.apirestjava.model.exception.ResourceNotFoundException;
import br.com.teste.apirestjava.repositories.ProdutoRepository;
import br.com.teste.apirestjava.shared.ProdutoDTO;
// import br.com.teste.apirestjava.view.model.ProdutoRequest;

@Service
public class ProdutoService {

    @Autowired
    // devolve uma instancia pronta do repositorio do produto sem precisar
    // instanciar.
    private ProdutoRepository produtoRepository;

    /**
     * Método que aciona o repositório para obter todos os produtos.
     * 
     * @return retorna uma lista de produtos.
     */
    public List<ProdutoDTO> obterTodos() {

        // o bd retorna uma lista de produtos
        List<Produto> produtos = produtoRepository.findAll();
        System.out.print(produtos);
        // converter em uma lista de produto DTO
        return produtos.stream().map(p -> new ModelMapper().map(p, ProdutoDTO.class)).collect(Collectors.toList());
    }

    /**
     * Método que aciona o repositório para obter um produto pelo id.
     * 
     * @return retorna o produto encontrado pelo id.
     */
    public Optional<ProdutoDTO> obterPorId(Integer id) {

        Optional<Produto> produtoId = produtoRepository.findById(id);

        // se o produto n existir é lnçada uma exceção
        if (produtoId.isEmpty()) {
            throw new ResourceNotFoundException("Produto de id: " + id + " não encontrado.");
        }

        ProdutoDTO dto = new ModelMapper().map(produtoId.get(), ProdutoDTO.class);
        // o método get() pega o retorno do Optional

        return Optional.of(dto);
        // o método of retorna um Optional de:
    }

    /**
     * Método que aciona o repositório para cadatrar um produto.
     * 
     * @return retorna o produto cadastrado.
     */
    public ProdutoDTO cadastrar(ProdutoDTO produtoDto) {
        // Poderia ter alguma regra de negocio para adicionar um produto aqui.
        // Ex: obrigatório passar o nome do produto, ou um valor acima de 100

        // seta o id do dto p/ null p/ garantir que vai acontecer uma inserção
        produtoDto.setId(null);
     
        // cria um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

        // converter o produto dto em um produto model p/ mandar pro bd
        Produto produto = mapper.map(produtoDto, Produto.class);

        // salvar o produto no bd - o produto mapeado tem o mesmo id do que foi salvo no bd
        produto = produtoRepository.save(produto);

        produtoDto.setId(produto.getId());

        // retornar o produto dto atualizado
        return produtoDto;
    }

    public void deletar(Integer id) {
        // Poderia ter alguma lógica de validação
        // Ex: ver se o usuário tem permissão para deletar.

        // Verificar se o produto existe p/ ser deletado
        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty()) {
            throw new ResourceNotFoundException("Não é possível deletar o produto de id:  " + id + " porque ele não existe.");
        }

        produtoRepository.deleteById(id);
    }

    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto) {

        // Passar o i p/ o produtoDTO
        produtoDto.setId(id);

        // Criar um objeto de mapeamento

        ModelMapper mapper = new ModelMapper();

        // Converter o DTO em model de Produto

        Produto produto = mapper.map(produtoDto, Produto.class);

        // Atualizar o produto no bd
        produtoRepository.save(produto);

        // retornar o produto dto atualizado (tem id? cadastra : atualiza)
        // produtoDto.setId(produto.getId());

        return produtoDto;
     
    }

}
