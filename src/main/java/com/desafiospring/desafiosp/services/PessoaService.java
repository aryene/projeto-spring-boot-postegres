package com.desafiospring.desafiosp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiospring.desafiosp.domain.Pessoa;
import com.desafiospring.desafiosp.dto.PessoaDTO;
import com.desafiospring.desafiosp.repository.PessoaRepository;
import com.desafiospring.desafiosp.services.exception.ObjectNotFoundException;
import java.util.Optional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository rep;
	
	@Autowired
    private TarefaService tarefaService;

	public List<Pessoa> findAll() {
		return (List<Pessoa>) rep.findAll();
	}

	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Pessoa insert(Pessoa obj) {
		return rep.save(obj);
	}

	public void delete(Long id) {
		Pessoa pessoa = findById(id);
		tarefaService.deleteTarefasByPessoa(pessoa); 
		rep.deleteById(id); 
	}

	public Pessoa update(Pessoa obj) {
		Pessoa newObj = findById(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}

	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setNome(obj.getNome());
	}

	public Pessoa fromDTO(PessoaDTO dto) {
		return new Pessoa(dto.getId(), dto.getNome(), null);
	}
}
