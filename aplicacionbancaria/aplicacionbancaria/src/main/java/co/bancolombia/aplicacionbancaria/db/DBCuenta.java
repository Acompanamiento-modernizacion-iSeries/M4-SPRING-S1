package co.bancolombia.aplicacionbancaria.db;

import co.bancolombia.aplicacionbancaria.modelo.CuentaBanco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DBCuenta {
    private static List<CuentaBanco> cuentas  = new ArrayList<>();
    public static void agregarCuenta(CuentaBanco cuenta) {
        cuentas.add(cuenta);
    }

    public static void agregarCuenta(){
        DBCuenta.agregarCuenta(new CuentaBanco("012345", new BigDecimal("1000")));
        DBCuenta.agregarCuenta(new CuentaBanco("678910", new BigDecimal("800")));
        DBCuenta.agregarCuenta(new CuentaBanco("111213", new BigDecimal("3200")));
        DBCuenta.agregarCuenta(new CuentaBanco("141516", new BigDecimal("2100")));
    }

    public static CuentaBanco buscarCuenta(String nroCuenta) {
        for (CuentaBanco cuenta : cuentas) {
            if (cuenta.getNroCuenta().equals(nroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}
