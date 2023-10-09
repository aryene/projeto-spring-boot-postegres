package com.desafiospring.desafiosp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiospring.desafiosp.domain.Departamento;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {


	
}
