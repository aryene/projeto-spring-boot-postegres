package com.desafiospring.desafiosp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiospring.desafiosp.domain.Setor;
import com.desafiospring.desafiosp.repository.SetorRepository;
import com.desafiospring.desafiosp.services.exception.ObjectNotFoundException;
import java.util.Optional;

@Service
public class SetorService {
	
	@Autowired
	private SetorRepository rep;

	  public List<Setor> findAll(){
		return rep.findAll();
	}
	
	  public Setor findById(Long id) {
		  Optional<Setor> obj = rep.findById(id);
		  return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		  }
}
