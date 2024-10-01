package com.bancolombia.cuentabancaria.entitys;

import java.math.BigDecimal;

public class CuentaBancariaEntity {

    private String cuenta;
    private BigDecimal saldo;

    public CuentaBancariaEntity(String cuenta, BigDecimal saldo) {
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void deposito(BigDecimal valor){
        saldo = saldo.add(valor);
    }

    public void retiro(BigDecimal valor){
        saldo = saldo.subtract(valor);
    }
}
