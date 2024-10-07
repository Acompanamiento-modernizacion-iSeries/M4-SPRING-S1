package co.bancolombia.aplicacionbancaria.model;

import java.math.BigDecimal;

public class Cuenta {

    private String numeroCuenta;
    private BigDecimal saldo;

    // Constructor

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = BigDecimal.ZERO;
    }

    //getters y setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal monto) {
        this.saldo = this.saldo.add(monto);
    }

    public boolean retirar(BigDecimal monto) {
        if (this.saldo.compareTo(monto) >= 0) {
            this.saldo = this.saldo.subtract(monto);
            return true;
        }
        return false;
    }
}
