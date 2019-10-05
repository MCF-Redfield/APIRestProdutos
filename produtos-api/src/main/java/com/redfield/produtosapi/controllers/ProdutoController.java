package com.redfield.produtosapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redfield.produtosapi.models.Produto;
import com.redfield.produtosapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController
{
	@Autowired
	ProdutoRepository produtoR;
	
	@GetMapping("/produtos")
	public List<Produto> getProdutos()
	{
		return produtoR.findAll();
	}

	@GetMapping("/produtos/{id}")
	public Optional<Produto >getProdutos(@PathVariable(value="id") long id)
	{
		return produtoR.findById(id);
	}
	
	@PostMapping("/produto")
	public Produto addProduto(@RequestBody Produto prod)
	{
		return produtoR.save(prod);
	}
	
	@DeleteMapping("/produto")
	public void deleteProduto(@RequestBody Produto prod)
	{
		produtoR.delete(prod);
	}
	
	@PutMapping("/produto")
	public Produto updateProduto(@RequestBody Produto prod)
	{
		return produtoR.save(prod);
	}
	
}
