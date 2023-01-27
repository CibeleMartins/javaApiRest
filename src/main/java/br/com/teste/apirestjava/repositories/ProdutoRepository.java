package br.com.teste.apirestjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.apirestjava.model.Produto;
import br.com.teste.apirestjava.view.model.ProdutoRequest;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    void save(ProdutoRequest novoProduto);
    
}
