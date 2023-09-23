package com.desafiospring.desafiosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiospring.desafiosp.domain.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
	
	
	
}
