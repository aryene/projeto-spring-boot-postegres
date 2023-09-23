package com.desafiospring.desafiosp.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.desafiospring.desafiosp.domain.Setor;
import com.desafiospring.desafiosp.repository.SetorRepository;

@Component
public class Instatiation implements CommandLineRunner{
	
	@Autowired
	private SetorRepository setorRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        setorRepository.deleteAll();
        
        Setor financeiro = new Setor(null, "Financeiro");
        Setor comercial = new Setor(null, "Comercial");
        Setor Desenvolvimento = new Setor(null, "Desenvolvimento");
        Setor rh = new Setor(null, "rh");
       
        
        setorRepository.saveAll(Arrays.asList(financeiro, comercial, Desenvolvimento,rh));
	}

}
