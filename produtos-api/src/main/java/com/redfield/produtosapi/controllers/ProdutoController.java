package com.redfield.produtosapi.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redfield.produtosapi.models.Produto;
import com.redfield.produtosapi.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/produtos")
@Api(value="API Rest Produtos")
@CrossOrigin(origins="")
public class ProdutoController
{
	@Autowired
	ProdutoRepository produtoR;
	
	@GetMapping
	@ApiOperation(value="Lista todos Produtos")
	public List<Produto> getProdutos()
	{
		return produtoR.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value="Busca Produto por ID")
	public ResponseEntity<Produto >getProduto(@PathVariable(value="id") long id)
	{
		Produto prod = produtoR.findById(id);
		if(prod!=null)
			return ResponseEntity.ok(prod);
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value="Cadastra Produto")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto addProduto(@NotNull @Valid @RequestBody Produto prod)
	{
		return produtoR.save(prod);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deleta Produto por ID")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduto(@PathVariable(value="id") long id)
	{
		produtoR.deleteById(id);
	}
	
	@PutMapping
	@ApiOperation(value="Atualiza Produto")
	public ResponseEntity<Produto> updateProduto(@NotNull @Valid @RequestBody Produto prod)
	{
		return ResponseEntity.ok(produtoR.save(prod));
	}
	
}
