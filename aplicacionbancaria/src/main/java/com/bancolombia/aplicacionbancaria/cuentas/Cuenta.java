package com.bancolombia.aplicacionbancaria.cuentas;

import java.math.BigDecimal;

public class Cuenta {

    private BigDecimal saldo;
    private Integer numeroCuenta;

    public Cuenta(BigDecimal saldo, Integer numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal obtenerSaldo() {
        return saldo;
    };

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    };

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    };

    public void retiro(BigDecimal cantidad){
        BigDecimal saldo = obtenerSaldo();
            saldo = saldo.subtract(cantidad);
            setSaldo(saldo);
    };


    public void deposito(BigDecimal cantidad) {
        BigDecimal saldo = obtenerSaldo();
        saldo = saldo.add(cantidad);
        setSaldo(saldo);
    }
}
