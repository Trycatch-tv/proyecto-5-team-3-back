package com.reservas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reservas.model.service.ReservasService;

@SpringBootApplication
public class ReservasApplication implements  CommandLineRunner{
	
	@Autowired
	private ReservasService reservasService;

	public static void main(String[] args) {
		SpringApplication.run(ReservasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		// TODO Auto-generated method stub
		
	}
	

}
