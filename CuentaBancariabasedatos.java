package co.bancolombia.aplicacionbancaria.basedatos;

import co.bancolombia.aplicacionbancaria.modelo.CuentaBancaria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancariabasedatos {

    private static List<CuentaBancaria> cuentas  = new ArrayList<>();

	public static CuentaBancaria buscarCuenta(String nroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNroCuenta().equals(nroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }	
	
	
    public static void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    public static void poblar(){
        CuentaBancariabasedatos.agregarCuenta(new CuentaBancaria("9876", new BigDecimal("9000000")));
        CuentaBancariabasedatos.agregarCuenta(new CuentaBancaria("5432", new BigDecimal("5000000")));
        CuentaBancariabasedatos.agregarCuenta(new CuentaBancaria("1098", new BigDecimal("1000000")));
    }

    

}
