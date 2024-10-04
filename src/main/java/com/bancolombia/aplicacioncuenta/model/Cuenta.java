package com.bancolombia.aplicacioncuenta.model;

import java.math.BigDecimal;

public class Cuenta {

    private String id;
    private BigDecimal saldo;

    // Constructor
    public Cuenta(String id, BigDecimal saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
