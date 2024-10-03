package co.banco.gestioncuenta.db;

import co.banco.gestioncuenta.model.Cuenta;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CuentaRepository {
    private Map<String, Cuenta> cuentas = new HashMap<>();

    @PostConstruct
    public void init() {
        for (int i = 100; i < 105; i++) {
            String numeroCuenta = String.valueOf(i);
            cuentas.put(numeroCuenta, new Cuenta(numeroCuenta));
        }
    }

    public Cuenta findByNumeroCuenta(String numeroCuenta) {
        return cuentas.get(numeroCuenta);
    }
}