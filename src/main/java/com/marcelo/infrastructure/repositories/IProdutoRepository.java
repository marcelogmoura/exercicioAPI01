package com.marcelo.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.domain.models.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Integer>{
	
	

}
