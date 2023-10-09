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
import com.desafiospring.desafiosp.domain.Tarefa;
import com.desafiospring.desafiosp.dto.TarefaDTO;
import com.desafiospring.desafiosp.services.PessoaService;
import com.desafiospring.desafiosp.services.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaResource {

	@Autowired
	private TarefaService service;
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<TarefaDTO>> findAll() {
		List<Tarefa> list = service.findAll();
		List<TarefaDTO> listDto = list.stream().map(x -> new TarefaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TarefaDTO> findById(@PathVariable Long id) {
		Tarefa obj = service.findById(id);
		return ResponseEntity.ok().body(new TarefaDTO(obj));
	}

	@PostMapping(value = "post/tarefas")
	public ResponseEntity<Void> insert(@RequestBody TarefaDTO dto) {
		Tarefa obj = service.fromDTO(dto);
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
	public ResponseEntity<Void> update(@RequestBody TarefaDTO dto, @PathVariable Long id) {
		Tarefa obj = service.fromDTO(dto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/alocar/{tarefaId}/{pessoaId}")
	public ResponseEntity<Void> alocarPessoaATarefaComMesmoDepartamento(
	    @PathVariable Long tarefaId, @PathVariable Long pessoaId) {
	    Tarefa tarefa = service.findById(tarefaId);
	    Pessoa pessoa = pessoaService.findById(pessoaId); // Você precisará injetar o serviço de Pessoa

	    if (tarefa.getDepartamento().equals(pessoa.getDepartamento())) {
	        tarefa.setPessoa(pessoa);
	        tarefa = service.update(tarefa);
	        return ResponseEntity.noContent().build();
	    } else {
	        // O departamento da tarefa e da pessoa não coincide
	        return ResponseEntity.badRequest().build();
	    }
	}

	
}
