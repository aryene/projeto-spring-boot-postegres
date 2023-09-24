package com.desafiospring.desafiosp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiospring.desafiosp.domain.Setor;

@Repository
public interface SetorRepository extends CrudRepository<Setor, Long> {


	
}
