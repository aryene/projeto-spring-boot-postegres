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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafiospring.desafiosp.domain.Departamento;
import com.desafiospring.desafiosp.dto.DepartamentoDTO;
import com.desafiospring.desafiosp.services.DepartamentoService;

@RestController
@RequestMapping(value = "/departamento")
public class DepartamentoResource {
	
	@Autowired
	private DepartamentoService service;
	
	@GetMapping
	public ResponseEntity<List<DepartamentoDTO>> findAll() {
		List<Departamento> list  = service.findAll();
		List<DepartamentoDTO> listDto =  list.stream().map(x -> new DepartamentoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartamentoDTO> findAll(@PathVariable Long id) {
		Departamento obj = service.findById(id);
		return ResponseEntity.ok().body(new DepartamentoDTO(obj));
	}
	
	@PostMapping
    public ResponseEntity<Void> insert(@RequestBody DepartamentoDTO dto) {
		Departamento obj = service.fromDTO(dto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
    }
	
	@PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody DepartamentoDTO dto, @PathVariable Long id) {
		Departamento obj = service.fromDTO(dto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

	
}
