package com.bancolombia.aplicacioncuenta.repository;

import com.bancolombia.aplicacioncuenta.model.Cuenta;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class CuentasDB {

    public static List<Cuenta> cuentas = new ArrayList<>();

    static {
        cuentas.add(new Cuenta("1001", new BigDecimal("1250.75")));
        cuentas.add(new Cuenta("2025", new BigDecimal("859.30")));
        cuentas.add(new Cuenta("3048", new BigDecimal("4789.10")));
        cuentas.add(new Cuenta("4576", new BigDecimal("302.50")));
        cuentas.add(new Cuenta("5099", new BigDecimal("6400.89")));
        cuentas.add(new Cuenta("6134", new BigDecimal("152.25")));
        cuentas.add(new Cuenta("7251", new BigDecimal("10500.00")));
    }
}
