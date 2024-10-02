package co.com.bancolombia.aplicacionbancaria.cuentas;

import java.math.BigDecimal;

public class Cuenta {
    protected String numeroCuenta;
    protected BigDecimal saldo;

    public Cuenta(String numeroCuenta, BigDecimal saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String consultarNumCuenta() {
        return numeroCuenta;
    }

    public BigDecimal consultarSaldo() {
        return saldo;
    }

    public boolean deposito(BigDecimal vlrTransacc) {
        if (vlrTransacc.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(vlrTransacc);
            return true;
        }
        return false;
    }

    public boolean retiro(BigDecimal vlrTransacc) {
        if (vlrTransacc.compareTo(BigDecimal.ZERO) >= 0 && vlrTransacc.compareTo(saldo) <= 0) {
            saldo = saldo.subtract(vlrTransacc);
            return true;
        }
        return false;
    }
}
