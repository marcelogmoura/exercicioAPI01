package com.marcelo.domain.interfaces;

import java.util.List;

import com.marcelo.domain.dtos.ProdutoGetDto;
import com.marcelo.domain.dtos.ProdutoPostDto;
import com.marcelo.domain.dtos.ProdutoPutDto;


public interface ProdutoService {
	
	ProdutoGetDto criar(ProdutoPostDto dto);
		
	ProdutoGetDto editar(ProdutoPutDto dto);
	
	ProdutoGetDto apagar(Integer id);
	
	List<ProdutoGetDto> consultar(Integer id);
	
	List<ProdutoGetDto> consultarTodos();

	
	
	
}
