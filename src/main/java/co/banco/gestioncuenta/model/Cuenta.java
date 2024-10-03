package co.banco.gestioncuenta.model;

import java.math.BigDecimal;

public class Cuenta {
    private String numeroCuenta;
    private BigDecimal saldo;

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = BigDecimal.ZERO;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(monto);
        }
    }

    public boolean retirar(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) > 0 && saldo.compareTo(monto) >= 0) {
            saldo = saldo.subtract(monto);
            return true;
        }
        return false;
    }
}