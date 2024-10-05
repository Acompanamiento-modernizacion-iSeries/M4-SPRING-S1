package com.bancolombia.aplicacionbancaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacionbancariaApplication {

	public static void main(String[] args) {

		SpringApplication.run(AplicacionbancariaApplication.class, args);
		System.out.println("Aplicacion Bancaria corriendo en el puerto 8080...");
	}

}
