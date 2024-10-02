package co.bancolombia.aplicacionbancaria;

import co.bancolombia.aplicacionbancaria.basedatos.CuentaBancariabasedatos;
import co.bancolombia.aplicacionbancaria.modelo.CuentaBancaria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class AplicacionbancariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionbancariaApplication.class, args);
		CuentaBancariabasedatos.poblar();
	}


}
