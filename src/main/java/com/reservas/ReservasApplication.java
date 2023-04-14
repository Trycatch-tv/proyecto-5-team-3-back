package com.reservas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.reservas.service.ClienteService;
import com.reservas.service.MesaService;
import com.reservas.service.ReservaService;

@SpringBootApplication
public class ReservasApplication implements  CommandLineRunner{
	
	@Autowired
	private ReservaService reservasService;
	@Autowired
	private MesaService mesasService;
	@Autowired
	private ClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(ReservasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		// TODO Auto-generated method stub
		
	}
	

}
