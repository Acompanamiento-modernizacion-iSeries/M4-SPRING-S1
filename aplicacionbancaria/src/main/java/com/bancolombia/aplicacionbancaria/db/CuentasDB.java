package com.bancolombia.aplicacionbancaria.db;



import com.bancolombia.aplicacionbancaria.cuentas.Cuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentasDB {

    private static List<Cuenta> cuentaList = new ArrayList<Cuenta>(
            List.of(
                    new Cuenta(new BigDecimal(1001), 1),
                    new Cuenta(new BigDecimal(1002), 2),
                    new Cuenta(new BigDecimal(1003), 3),
                    new Cuenta(new BigDecimal(1004), 4),
                    new Cuenta(new BigDecimal(1005), 5),
                    new Cuenta(new BigDecimal(1006), 6),
                    new Cuenta(new BigDecimal(1007), 7),
                    new Cuenta(new BigDecimal(1008), 8),
                    new Cuenta(new BigDecimal(1009), 9),
                    new Cuenta(new BigDecimal(1010), 10)
            )
    );

    public Cuenta getCuenta(Integer numeroCuenta) {
        for (Cuenta cuenta : cuentaList) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    };
}
