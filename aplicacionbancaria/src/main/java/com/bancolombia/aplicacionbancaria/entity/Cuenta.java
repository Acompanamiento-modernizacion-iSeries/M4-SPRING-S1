package com.bancolombia.aplicacionbancaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Cuenta {

    @Id
    private Long numeroCuenta;
    private BigDecimal saldo;

    public Cuenta() {}

    public Cuenta(Long numeroCuenta, BigDecimal saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void depositar(BigDecimal cantidad) {
        this.saldo = this.saldo.add(cantidad);
    }

    public boolean retirar(BigDecimal cantidad) {
        if (this.saldo.compareTo(cantidad) >= 0) {
            this.saldo = this.saldo.subtract(cantidad);
            return true;
        }
        return false;
    }
}
