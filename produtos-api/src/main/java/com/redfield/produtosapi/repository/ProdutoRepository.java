package com.redfield.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfield.produtosapi.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>
{
	public Produto findById(long id);
}
