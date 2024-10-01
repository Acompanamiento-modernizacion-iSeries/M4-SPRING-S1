package co.bancolombia.aplicacionbancaria;

import co.bancolombia.aplicacionbancaria.bd.CuentaBancariaBD;
import co.bancolombia.aplicacionbancaria.model.CuentaBancaria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class AplicacionbancariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionbancariaApplication.class, args);
		//Crear e inicializar cuentas en memoria.
		CuentaBancariaBD.inicializarCuentas();
	}


}
