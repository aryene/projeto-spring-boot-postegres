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

import com.desafiospring.desafiosp.domain.Pessoa;
import com.desafiospring.desafiosp.dto.PessoaDTO;
import com.desafiospring.desafiosp.services.PessoaService;


@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll() {
		List<Pessoa> list  = service.findAll();
		List<PessoaDTO> listDto =  list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> findAll(@PathVariable Long id) {
		Pessoa obj = service.findById(id);
		return ResponseEntity.ok().body(new PessoaDTO(obj));
	}
	
	@PostMapping(value = "post/pessoas")
    public ResponseEntity<Void> insert(@RequestBody PessoaDTO dto) {
		Pessoa obj = service.fromDTO(dto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
	
	@DeleteMapping(value = "deleta/pessoas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
    }
	
	@PutMapping(value = "put/pessoas/{id}")
    public ResponseEntity<Void> update(@RequestBody PessoaDTO dto, @PathVariable Long id) {
		Pessoa obj = service.fromDTO(dto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }


	
	
}
