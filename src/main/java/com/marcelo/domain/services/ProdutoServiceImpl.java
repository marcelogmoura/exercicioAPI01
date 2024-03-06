package com.marcelo.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.domain.dtos.ProdutoGetDto;
import com.marcelo.domain.dtos.ProdutoPostDto;
import com.marcelo.domain.dtos.ProdutoPutDto;
import com.marcelo.domain.interfaces.ProdutoService;
import com.marcelo.domain.models.Produto;
import com.marcelo.infrastructure.repositories.IProdutoRepository;


@Service
public class ProdutoServiceImpl implements ProdutoService{
		
	@Autowired
	IProdutoRepository iProdutoRepository;

	@Override
	public ProdutoGetDto criar(ProdutoPostDto dto) {
		
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
		
		return response;
	}

	@Override
	public List<ProdutoGetDto> consultar(Integer id) {
		
	    try {
	        Optional<Produto> produtoOptional = iProdutoRepository.findById(id);
	        
	        if (produtoOptional.isPresent()) {
	        	
	            Produto produto = produtoOptional.get();
	            
	            ProdutoGetDto produtoDto = new ProdutoGetDto();
	            
	            produtoDto.setIdProduto(produto.getIdProduto());
	            produtoDto.setNome(produto.getNome());
	            produtoDto.setDescricao(produto.getDescricao());
	            produtoDto.setPreco(produto.getPreco());
	            produtoDto.setQuantidade(produto.getQuantidade());
	            
	            List<ProdutoGetDto> produtos = new ArrayList<>();
	            
	            produtos.add(produtoDto);
	            
	            return produtos;
	            
	        } else {
	            return new ArrayList<>();  
	        }
	    } catch (Exception e) {
	    	
	    		
	        return null;  
	    }
	}
	

	@Override
	public ProdutoGetDto apagar(Integer id) {
		
		try {			
			Optional<Produto> produtoOptional = iProdutoRepository.findById(id);
			
			if(produtoOptional.isPresent()) {
				
				Produto produto = produtoOptional.get();
				
				iProdutoRepository.delete(produto);
				
				ProdutoGetDto response = new ProdutoGetDto();
				
				response.setIdProduto(produto.getIdProduto());
				response.setNome(produto.getNome());
				response.setDescricao(produto.getDescricao());
				response.setPreco(produto.getPreco());
				response.setQuantidade(produto.getQuantidade());
				
				return response;
				
			}else {
				return null;
			}
		}catch (Exception e) {

		}
		
		return null;
	}

	
	@Override
	public List<ProdutoGetDto> consultarTodos() {
		
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

		return lista;
	}

	@Override
	public ProdutoGetDto editar(ProdutoPutDto dto) {
		
		Optional<Produto> produtoOptional = iProdutoRepository.findById(dto.getIdProduto());
		
		if(produtoOptional.isPresent()) {
			
			Produto produto = produtoOptional.get();
			
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
			
			return response;
			
		}else {
			
		}		
		return null;
	}





	


	
	
	

	

}
