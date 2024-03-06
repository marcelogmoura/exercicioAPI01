package com.marcelo.domain.dtos;

import lombok.Data;

@Data
public class ProdutoGetDto {
	
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidade;
	
	

}
