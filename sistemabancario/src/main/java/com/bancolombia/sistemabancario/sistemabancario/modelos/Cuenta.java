package com.bancolombia.sistemabancario.sistemabancario.modelos;

import java.math.BigDecimal;

public class Cuenta {

    private String cuenta;
    private BigDecimal saldo;

    
    public Cuenta() {
    }
    public Cuenta(String cuenta, BigDecimal saldo) {
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

    

}
