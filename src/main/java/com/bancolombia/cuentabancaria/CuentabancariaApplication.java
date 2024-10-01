package com.bancolombia.cuentabancaria;

import com.bancolombia.cuentabancaria.repository.CuentasBancariasBD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CuentabancariaApplication {

	public static void main(String[] args) {
		CuentasBancariasBD cuentasBancariasBD = new CuentasBancariasBD();
		cuentasBancariasBD.iniciarData();
		SpringApplication.run(CuentabancariaApplication.class, args);
	}

}
