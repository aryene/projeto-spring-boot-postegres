package com.desafiospring.desafiosp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiospring.desafiosp.domain.Setor;
import com.desafiospring.desafiosp.dto.SetorDTO;
import com.desafiospring.desafiosp.repository.SetorRepository;
import com.desafiospring.desafiosp.services.exception.ObjectNotFoundException;
import java.util.Optional;

@Service
public class SetorService {

	@Autowired
	private SetorRepository rep;

	public List<Setor> findAll() {
		return (List<Setor>) rep.findAll();
	}

	public Setor findById(Long id) {
		Optional<Setor> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Setor insert(Setor obj) {
        return rep.save(obj);
    }
	
	public void delete(Long id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public Setor fromDTO(SetorDTO dto) {
        return new Setor(dto.getId(), dto.getNome());
    }

}
