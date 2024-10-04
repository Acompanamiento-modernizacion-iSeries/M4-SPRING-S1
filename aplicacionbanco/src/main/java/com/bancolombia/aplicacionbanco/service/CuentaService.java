package com.bancolombia.aplicacionbanco.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class CuentaService {

    private BigDecimal saldo = new BigDecimal(1000);

    public BigDecimal obtenerSaldo(){
        return saldo;
    }

    public BigDecimal depositar(BigDecimal monto) {
        if(monto.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        saldo = saldo.add(monto);
        return saldo;
    }

    public BigDecimal retirar(BigDecimal monto){
        if(monto.compareTo(saldo) > 0){
            throw  new IllegalStateException("Saldo insuficiente para este retiro");
        }
        saldo = saldo.subtract(monto);
        return saldo;
    }

}
