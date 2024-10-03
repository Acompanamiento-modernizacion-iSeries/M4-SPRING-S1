package co.bancolombia.aplicacionbancaria.model;

import java.math.BigDecimal;


public class Cuenta {

    private String cuentaId;
    private BigDecimal saldo;
    private String tipoCuenta;

    public Cuenta() {

    }
    public Cuenta(String cuentaId, BigDecimal saldo, String tipoCuenta) {
        this.cuentaId = cuentaId;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    public String getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(String cuentaId) {
        this.cuentaId = cuentaId;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
}
