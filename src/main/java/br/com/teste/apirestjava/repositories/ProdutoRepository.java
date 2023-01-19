package br.com.teste.apirestjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.apirestjava.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
