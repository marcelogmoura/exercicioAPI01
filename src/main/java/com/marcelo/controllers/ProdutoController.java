package com.marcelo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.domain.dtos.ProdutoGetDto;
import com.marcelo.domain.dtos.ProdutoPostDto;
import com.marcelo.domain.dtos.ProdutoPutDto;
import com.marcelo.domain.interfaces.ProdutoService;
import com.marcelo.infrastructure.repositories.IProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
		
	@Autowired
	IProdutoRepository iProdutoRepository;
	
	@PostMapping
	public ProdutoGetDto post(@RequestBody @Valid ProdutoPostDto dto) {
		return produtoService.criar(dto);
	}	

	@PutMapping
	public ProdutoGetDto pu(@RequestBody @Valid ProdutoPutDto dto) {
		return produtoService.editar(dto);
	}
	
	@GetMapping
	public List<ProdutoGetDto> getAll(){
		return produtoService.consultarTodos();
	}	

	@GetMapping("{id}")
	public List<ProdutoGetDto> get(@PathVariable("id") Integer id){
		return produtoService.consultar(id);
	}
	
	@DeleteMapping("/{id}")
	public ProdutoGetDto delete(@PathVariable("id") Integer id) {
		return produtoService.apagar(id);
	}

	
	
	
	/*

	@PostMapping
	public ResponseEntity<ProdutoGetDto> post(@RequestBody @Valid ProdutoPostDto dto) {
		
		Produto produto = new Produto();
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setQuantidade(dto.getQuantidade());
		
		iProdutoRepository.save(produto);
		
		ProdutoGetDto response = new ProdutoGetDto();
		
		response.setIdProduto(produto.getIdProduto());
		response.setNome(produto.getNome());
		response.setDescricao(produto.getDescricao());
		response.setPreco(produto.getPreco());
		response.setQuantidade(produto.getQuantidade());
		
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(response);
	}
	
	*/
	
	/*
	
	
	@PutMapping
	public ResponseEntity<ProdutoGetDto> put(@RequestBody @Valid ProdutoPutDto dto) {
		
		Optional<Produto> busca = iProdutoRepository.findById(dto.getIdProduto());
		
		if(busca.isPresent()) {
			
			Produto produto = busca.get();
			
			produto.setNome(dto.getNome());
			produto.setDescricao(dto.getDescricao());
			produto.setPreco(dto.getPreco());
			produto.setQuantidade(dto.getQuantidade());
			
			iProdutoRepository.save(produto);
			
			ProdutoGetDto response = new ProdutoGetDto();
			
			response.setIdProduto(produto.getIdProduto());
			response.setNome(produto.getNome());
			response.setDescricao(produto.getDescricao());
			response.setPreco(produto.getPreco());
			response.setQuantidade(produto.getQuantidade());
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(response);			
		}else {			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(null);
		}
	}
	
	*/
	
	/*

	@DeleteMapping("{id}")
	public ResponseEntity<ProdutoGetDto> delete(@PathVariable("id") Integer idProduto) {
		
		Optional<Produto> busca = iProdutoRepository.findById(idProduto);
		
		if(busca.isPresent()) {
			
			Produto produto = busca.get();
			
			iProdutoRepository.delete(produto);
			
			ProdutoGetDto response = new ProdutoGetDto();
			
			response.setIdProduto(produto.getIdProduto());
			response.setNome(produto.getNome());
			response.setDescricao(produto.getDescricao());
			response.setPreco(produto.getPreco());
			response.setQuantidade(produto.getQuantidade());
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(response);
		}else {		
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(null);			
		}
	}
	
	*/

	/*
	
	@GetMapping
	public ResponseEntity<List<ProdutoGetDto>> getAll() {
		
		List<ProdutoGetDto> lista = new ArrayList<ProdutoGetDto>();
		
		for(Produto produto : iProdutoRepository.findAll()) {

			ProdutoGetDto dto = new ProdutoGetDto();
			 
	        dto.setIdProduto(produto.getIdProduto());
	        dto.setNome(produto.getNome());
	        dto.setDescricao(produto.getDescricao());
	        dto.setPreco(produto.getPreco());
	        dto.setQuantidade(produto.getQuantidade());
	        
	        lista.add(dto);
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(lista);
	}
	
	
	*/
	/*
	
	@GetMapping("{id}")
	public ResponseEntity<Produto> getById(@PathVariable("id") Integer id) {
		
		try {
			Optional<Produto> produto = iProdutoRepository.findById(id);
			
			if (produto.isPresent()) {
				
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(produto.get());
			} else {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.build();
			}
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
		}
		
	}
	
	*/

}



