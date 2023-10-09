package com.desafiospring.desafiosp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiospring.desafiosp.domain.Pessoa;
import com.desafiospring.desafiosp.domain.Tarefa;
import com.desafiospring.desafiosp.dto.TarefaDTO;
import com.desafiospring.desafiosp.repository.TarefaRepository;
import com.desafiospring.desafiosp.services.exception.ObjectNotFoundException;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository rep;

	public List<Tarefa> findAll() {
		return (List<Tarefa>) rep.findAll();
	}

	public Tarefa findById(Long id) {
		Optional<Tarefa> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Tarefa insert(Tarefa obj) {
		return rep.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public void deleteTarefasByPessoa(Pessoa pessoa) {
	    List<Tarefa> tarefas = rep.findByPessoa(pessoa);
	    rep.deleteAll(tarefas);
	}
	  
	public Tarefa update(Tarefa obj) {
		Tarefa newObj = findById(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}

	private void updateData(Tarefa newObj, Tarefa obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setTitulo(obj.getTitulo());
		// Atualize outros campos conforme necessário
	}

	public Tarefa fromDTO(TarefaDTO dto) {
		return new Tarefa(dto.getId(), dto.getTitulo(), dto.getDescricao(), dto.getPrazo(), null, dto.getDuracao(),
				null, dto.getFinalizado());
	}
}
