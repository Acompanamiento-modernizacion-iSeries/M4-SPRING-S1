package co.bancolombia.datacuenta;

import co.bancolombia.model.CuentaBanco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataCuentas {

    private static List<CuentaBanco> cuentas  = new ArrayList<>();

    public static void agregarCuenta(CuentaBanco cuenta) {
        cuentas.add(cuenta);
    }

    public static void inicializarCuentas(){
        DataCuentas.agregarCuenta(new CuentaBanco("9876", new BigDecimal("2000")));
        DataCuentas.agregarCuenta(new CuentaBanco("7654", new BigDecimal("4000")));
        DataCuentas.agregarCuenta(new CuentaBanco("5432", new BigDecimal("6000")));
        DataCuentas.agregarCuenta(new CuentaBanco("3210", new BigDecimal("8000")));
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
