package com.desafiospring.desafiosp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
    public ResponseEntity<Void> insert(@RequestBody SetorDTO dto) {
		Setor obj = service.fromDTO(dto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
    }


	
	
}
