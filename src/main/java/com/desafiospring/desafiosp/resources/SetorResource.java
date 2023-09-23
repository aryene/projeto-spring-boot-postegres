package com.desafiospring.desafiosp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiospring.desafiosp.domain.Setor;
import com.desafiospring.desafiosp.dto.SetorDTO;
import com.desafiospring.desafiosp.services.SetorService;

@RestController
@RequestMapping(value = "/setores")
public class SetorResource {
	
	@Autowired
	private SetorService service;
	
	@GetMapping
	public ResponseEntity<List<SetorDTO>> findAll() {
		List<Setor> list  = service.findAll();
		List<SetorDTO> listDto =  list.stream().map(x -> new SetorDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SetorDTO> findAll(@PathVariable Long id) {
			Setor obj = service.findById(id);
		return ResponseEntity.ok().body(new SetorDTO(obj));
	}
	
	
}
