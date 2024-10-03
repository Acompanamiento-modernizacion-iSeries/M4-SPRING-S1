package com.bancolombia.aplicacionbancaria.cuenta;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentaDB {
    private List<Cuenta> cuentas;

    public CuentaDB() {
        cuentas = new ArrayList<>();
        // Inicializando cuentas sin bucles
        cuentas.add(new Cuenta("CUENTA-1", 1100.0));
        cuentas.add(new Cuenta("CUENTA-2", 1200.0));
        cuentas.add(new Cuenta("CUENTA-3", 1300.0));
        cuentas.add(new Cuenta("CUENTA-4", 1400.0));
        cuentas.add(new Cuenta("CUENTA-5", 1500.0));
        cuentas.add(new Cuenta("CUENTA-6", 1600.0));
        cuentas.add(new Cuenta("CUENTA-7", 1700.0));
        cuentas.add(new Cuenta("CUENTA-8", 1800.0));
        cuentas.add(new Cuenta("CUENTA-9", 1900.0));
        cuentas.add(new Cuenta("CUENTA-10", 2000.0));
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public Cuenta buscarCuenta(String numeroCuenta) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .orElse(null);
    }
}

