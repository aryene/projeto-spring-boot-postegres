package com.desafiospring.desafiosp.dto;

import java.time.LocalDate;

import com.desafiospring.desafiosp.domain.Tarefa;

public class TarefaDTO {
	
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private Integer duracao;
    private Boolean finalizado;
    private PessoaDTO pessoaAlocada; 
    
    public TarefaDTO(){
	}
    
    public TarefaDTO(Tarefa obj) {
		id = obj.getId();
		titulo = obj.getTitulo();
		descricao = obj.getDescricao();
		prazo = obj.getPrazo();
		duracao = obj.getDuracao();
		finalizado = obj.getFinalizado();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getPrazo() {
		return prazo;
	}

	public void setPrazo(LocalDate prazo) {
		this.prazo = prazo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public PessoaDTO getPessoaAlocada() {
		return pessoaAlocada;
	}

	public void setPessoaAlocada(PessoaDTO pessoaAlocada) {
		this.pessoaAlocada = pessoaAlocada;
	}
    
	
    
    
    

}
