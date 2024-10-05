package com.bancolombia.aplicacionbancaria.repository;

import com.bancolombia.aplicacionbancaria.model.Cuenta;

import java.math.BigDecimal;
import java.util.List;

public class CuentasDB {

    public static List<Cuenta> cuentas = List.of(
            new Cuenta("123456", "Juan Perez", "Ahorros", new BigDecimal("1000.00")),
            new Cuenta("654321", "Maria Lopez", "Corriente", new BigDecimal("2000.00")),
            new Cuenta("987654", "Pedro Ramirez", "Ahorros", new BigDecimal("3000.00"))
    );

}
