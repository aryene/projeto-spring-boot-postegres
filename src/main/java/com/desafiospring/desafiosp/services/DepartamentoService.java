package com.desafiospring.desafiosp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiospring.desafiosp.domain.Departamento;
import com.desafiospring.desafiosp.dto.DepartamentoDTO;
import com.desafiospring.desafiosp.repository.DepartamentoRepository;
import com.desafiospring.desafiosp.services.exception.ObjectNotFoundException;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository rep;

	public List<Departamento> findAll() {
		return (List<Departamento>) rep.findAll();
	}

	public Departamento findById(Long id) {
		Optional<Departamento> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Departamento insert(Departamento obj) {
		return rep.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public Departamento update(Departamento obj) {
		Departamento newObj = findById(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}

	private void updateData(Departamento newObj, Departamento obj) {
		newObj.setTitulo(obj.getTitulo());
	}

	public Departamento fromDTO(DepartamentoDTO dto) {
		return new Departamento(dto.getId(), dto.getTitulo());
	}

}
