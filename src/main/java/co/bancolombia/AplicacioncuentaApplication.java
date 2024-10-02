package co.bancolombia;

import co.bancolombia.datacuenta.DataCuentas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacioncuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacioncuentaApplication.class, args);
		DataCuentas.inicializarCuentas();

	}

}
