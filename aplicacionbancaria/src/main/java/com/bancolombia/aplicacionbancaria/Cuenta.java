package com.bancolombia.aplicacionbancaria;

import java.math.BigDecimal;

public class Cuenta {

    private Integer cuenta;
    private BigDecimal saldo;

    public Cuenta(Integer cuenta, BigDecimal saldo) {
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public boolean deposito(BigDecimal monto){
      if(monto.compareTo(BigDecimal.valueOf(0)) > 0){
          saldo = saldo.add(monto);
          return true;
      }else {
          return false;
      }
    }

    public Integer retiro(BigDecimal monto){
        Integer respuesta;
        if(monto.compareTo(BigDecimal.valueOf(0)) > 0){
            if(monto.compareTo(getSaldo()) > 0){
               return 1;
            }
            else {
                saldo = saldo.subtract(monto);
                return 0;
            }
        }else {
            return 2;
        }
    }
}
