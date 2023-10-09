package com.desafiospring.desafiosp.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.desafiospring.desafiosp.domain.Departamento;
import com.desafiospring.desafiosp.domain.Pessoa;
import com.desafiospring.desafiosp.domain.Tarefa;
import com.desafiospring.desafiosp.repository.DepartamentoRepository;
import com.desafiospring.desafiosp.repository.PessoaRepository;
import com.desafiospring.desafiosp.repository.TarefaRepository;

@Component
public class Instatiation implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public void run(String... args) throws Exception {

		tarefaRepository.deleteAll();
		pessoaRepository.deleteAll();
		departamentoRepository.deleteAll();
		
		// Crie instâncias de Departamento
        Departamento financeiro = new Departamento(null, "Financeiro");
        Departamento comercial = new Departamento(null, "Comercial");
        Departamento desenvolvimento = new Departamento(null, "Desenvolvimento");

     // Crie instâncias de Pessoa
        Pessoa camila = new Pessoa(null, "Camila", financeiro);
        Pessoa pedro = new Pessoa(null, "Pedro", comercial);
        Pessoa fabiano = new Pessoa(null, "Fabiano", desenvolvimento);
        Pessoa raquel = new Pessoa(null, "Raquel", desenvolvimento);
        Pessoa patricia = new Pessoa(null, "Patricia", desenvolvimento);
        Pessoa joaquim = new Pessoa(null, "Joaquim", financeiro);
        
     // Salve as pessoas no banco de dados
        pessoaRepository.saveAll(Arrays.asList(camila, pedro, fabiano, raquel, patricia, joaquim));

     // Crie instâncias de Tarefa
        Tarefa tarefa1 = new Tarefa(null, "Validar NF Janeiro", "Validar notas recebidas no mês de Janeiro",
                LocalDate.of(2022, 2, 15), financeiro, 14, camila, true);
        Tarefa tarefa2 = new Tarefa(null, "Bug 352", "Corrigir bug 352 na versão 1.25",
                LocalDate.of(2022, 5, 10), comercial, 3, pedro, true);
        Tarefa tarefa3 = new Tarefa(null, "Liberação da versão 1.24", "Disponibilizar pacote para testes",
                LocalDate.of(2022, 2, 2), desenvolvimento, 25, fabiano, false);
        Tarefa tarefa4 = new Tarefa(null, "Reunião A", "Reunião com cliente A para apresentação do produto",
                LocalDate.of(2022, 2, 15), desenvolvimento, 2, raquel, false);
        Tarefa tarefa5 = new Tarefa(null, "Reunião final", "Fechamento contrato",
                LocalDate.of(2022, 2, 15), desenvolvimento, 2, patricia, false);
        Tarefa tarefa6 = new Tarefa(null, "Reunião A", "Realizar pagamento dos fornecedores",
                LocalDate.of(2022, 2, 15), financeiro, 6, joaquim, false);    


		// Salvando
        tarefaRepository.saveAll(Arrays.asList(tarefa1, tarefa2,tarefa3,tarefa4,tarefa5,tarefa6));

	}

}
