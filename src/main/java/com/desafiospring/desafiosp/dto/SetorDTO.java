package com.desafiospring.desafiosp.dto;

import java.io.Serializable;

import com.desafiospring.desafiosp.domain.Setor;

public class SetorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	public SetorDTO(){
	}
	
	public SetorDTO(Setor obj) {
		id = obj.getId();
		nome = obj.getNome();

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
	
	
}
