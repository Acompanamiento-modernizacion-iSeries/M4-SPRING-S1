package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.model.Cuenta;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CuentaService {

    private Map<String, Cuenta> cuentas = new HashMap<>();

    public CuentaService() {

        cuentas.put("123456789", new Cuenta("123456789"));
        cuentas.put("987654321", new Cuenta("987654321"));
    }

    public BigDecimal obtenerSaldo(String numeroCuenta) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        return cuenta != null ? cuenta.getSaldo() : BigDecimal.ZERO;
    }

    public void depositar(String numeroCuenta, BigDecimal monto) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && monto.compareTo(BigDecimal.ZERO) > 0) {
            cuenta.depositar(monto);
        }
    }

    public boolean retirar(String numeroCuenta, BigDecimal monto) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && monto.compareTo(BigDecimal.ZERO) > 0) {
            return cuenta.retirar(monto);
        }
        return false;
    }
}
