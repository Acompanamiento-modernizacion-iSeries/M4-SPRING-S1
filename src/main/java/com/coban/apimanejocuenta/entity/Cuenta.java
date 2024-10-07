package com.coban.apimanejocuenta.entity;

import java.math.BigDecimal;

public class Cuenta {
    private String id;
    private String nombre;
    private String tipo;
    private BigDecimal saldo;

    public Cuenta() {
    }

    public Cuenta(String id, String nombre, String tipo, BigDecimal saldo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
