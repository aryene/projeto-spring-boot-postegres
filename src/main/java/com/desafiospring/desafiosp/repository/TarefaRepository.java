package com.desafiospring.desafiosp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiospring.desafiosp.domain.Pessoa;
import com.desafiospring.desafiosp.domain.Tarefa;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
	List<Tarefa> findByPessoa(Pessoa pessoa);

	
}
