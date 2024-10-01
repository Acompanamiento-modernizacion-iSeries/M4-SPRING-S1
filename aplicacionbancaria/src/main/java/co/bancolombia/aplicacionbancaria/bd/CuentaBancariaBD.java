package co.bancolombia.aplicacionbancaria.bd;

import co.bancolombia.aplicacionbancaria.model.CuentaBancaria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancariaBD {

    private static List<CuentaBancaria> cuentas  = new ArrayList<>();

    //Inicializar cuentas en memoria.
    public static void inicializarCuentas(){
        CuentaBancariaBD.agregarCuenta(new CuentaBancaria("1128935", new BigDecimal("1200000")));
        CuentaBancariaBD.agregarCuenta(new CuentaBancaria("8776521", new BigDecimal("2000000")));
        CuentaBancariaBD.agregarCuenta(new CuentaBancaria("9872123", new BigDecimal("3000000")));
        CuentaBancariaBD.agregarCuenta(new CuentaBancaria("1276311", new BigDecimal("200000")));
        CuentaBancariaBD.agregarCuenta(new CuentaBancaria("9864123", new BigDecimal("10000")));
    }

    //Agregar cuenta a la lista de cuentas.
    public static void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    //Buscar cuenta por número de cuenta.
    public static CuentaBancaria buscarCuenta(String nroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.consultarCuenta().equals(nroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

}
