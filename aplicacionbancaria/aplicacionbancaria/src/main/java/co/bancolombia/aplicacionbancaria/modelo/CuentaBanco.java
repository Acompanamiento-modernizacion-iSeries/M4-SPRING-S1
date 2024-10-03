package co.bancolombia.aplicacionbancaria.modelo;

import java.math.BigDecimal;

public class CuentaBanco {

    private String nroCuenta;
    private BigDecimal saldo;

    public CuentaBanco(String nroCuenta, BigDecimal saldo) {
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void depositar (BigDecimal monto){
        saldo = saldo.add(monto);
    }

    public void retirar (BigDecimal monto){
        saldo = saldo.subtract(monto);
    }

}
