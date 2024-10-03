package co.bancolombia.aplicacionbancaria;

import co.bancolombia.aplicacionbancaria.db.DBCuenta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacionbancariaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AplicacionbancariaApplication.class, args);
		DBCuenta.agregarCuenta();
	}
}
