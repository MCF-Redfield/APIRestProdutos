package com.redfield.produtosapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="API Rest Produtos")
@CrossOrigin(origins="")
public class ProdutoController
{
	@Autowired
	ProdutoRepository produtoR;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Lista Produtos")
	public List<Produto> getProdutos()
	{
		return produtoR.findAll();
	}

	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Busca Produto por ID")
	public Optional<Produto >getProduto(@PathVariable(value="id") long id)
	{
		return produtoR.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Cadastra Produto")
	public Produto addProduto(@RequestBody Produto prod)
	{
		return produtoR.save(prod);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta Produto")
	public void deleteProduto(@RequestBody Produto prod)
	{
		produtoR.delete(prod);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza Produto")
	public Produto updateProduto(@RequestBody Produto prod)
	{
		return produtoR.save(prod);
	}
	
}
