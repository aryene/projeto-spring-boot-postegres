package com.desafiospring.desafiosp.dto;

import java.io.Serializable;

import com.desafiospring.desafiosp.domain.Departamento;

public class DepartamentoDTO implements Serializable{

		private static final long serialVersionUID = 1L;
		
	    private Long id;
	    private String titulo;
		
		public DepartamentoDTO(){
		}
		
		public DepartamentoDTO(Departamento obj) {
			id = obj.getId();
			titulo = obj.getTitulo();

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

		
		

}
