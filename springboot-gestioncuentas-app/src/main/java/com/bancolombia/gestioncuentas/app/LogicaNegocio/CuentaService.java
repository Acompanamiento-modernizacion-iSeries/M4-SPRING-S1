package com.bancolombia.gestioncuentas.app.LogicaNegocio;

import com.bancolombia.gestioncuentas.app.ModeloCuenta.Cuenta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    private final List<Cuenta> cuentas = new ArrayList<>();

    public CuentaService() {
        // Precargar cuentas en memoria
        cuentas.add(new Cuenta("12345", 1000.0));
        cuentas.add(new Cuenta("67890", 500.0));
    }

    public Optional<Cuenta> obtenerCuenta(String numeroCuenta) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta))
                .findFirst();
    }

    public void depositar(String numeroCuenta, double monto) {
        obtenerCuenta(numeroCuenta).ifPresent(cuenta -> cuenta.setSaldo(cuenta.getSaldo() + monto));
    }

    public boolean retirar(String numeroCuenta, double monto) {
        Optional<Cuenta> cuentaOpt = obtenerCuenta(numeroCuenta);
        if (cuentaOpt.isPresent()) {
            Cuenta cuenta = cuentaOpt.get();
            if (cuenta.getSaldo() >= monto) {
                cuenta.setSaldo(cuenta.getSaldo() - monto);
                return true;
            }
        }
        return false;
    }
}