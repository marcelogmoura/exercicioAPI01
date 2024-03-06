package com.marcelo.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProdutoPostDto {
	
	@NotBlank(message = "ñ pode ser vazio")
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidade;

}
