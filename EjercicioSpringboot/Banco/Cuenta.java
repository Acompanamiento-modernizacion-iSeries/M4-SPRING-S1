package com.example.EjercicioSpringboot.Banco;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numeroCuenta;
    private BigDecimal saldo;

    public Cuenta(String numeroCuenta, BigDecimal saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public static List<Cuenta> crearCuentas() {
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(new Cuenta("111111", new BigDecimal(10000.00)));
        cuentas.add(new Cuenta("222222", new BigDecimal(5000.00)));
        cuentas.add(new Cuenta("333333", new BigDecimal(7500.00)));
        return cuentas;
    }
}
