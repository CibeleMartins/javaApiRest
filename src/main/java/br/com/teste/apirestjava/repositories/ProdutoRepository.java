package br.com.teste.apirestjava.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import br.com.teste.apirestjava.model.Produto;

@Repository
public class ProdutoRepository {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();

}
