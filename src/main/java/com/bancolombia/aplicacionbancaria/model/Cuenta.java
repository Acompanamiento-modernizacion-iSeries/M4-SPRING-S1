package com.bancolombia.aplicacionbancaria.model;

import java.math.BigDecimal;

public class Cuenta {
    private String numeroCuenta;
    private String nombre;
    private String tipoCuenta;
    private BigDecimal saldo;

    public Cuenta(String numeroCuenta, String nombre, String tipoCuenta, BigDecimal saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
