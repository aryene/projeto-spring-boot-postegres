package com.desafiospring.desafiosp.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.desafiospring.desafiosp.domain.Departamento;
import com.desafiospring.desafiosp.domain.Pessoa;


public class PessoaDTO {

	private Long id;
	private String nome;
	private Departamento departamento;
	private List<TarefaDTO> tarefas; // Representa a lista de tarefas da pessoa

	public PessoaDTO() {
	}

	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
		departamento = obj.getDepartamento();
		tarefas =  obj.getTarefas().stream().map(tarefa -> new TarefaDTO(tarefa)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<TarefaDTO> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<TarefaDTO> tarefas) {
		this.tarefas = tarefas;
	}

}
