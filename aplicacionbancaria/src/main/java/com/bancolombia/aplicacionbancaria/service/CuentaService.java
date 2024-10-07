package com.bancolombia.aplicacionbancaria.service;

import com.bancolombia.aplicacionbancaria.cuentas.Cuenta;
import com.bancolombia.aplicacionbancaria.db.CuentasDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaService {

    private Cuenta cuentaEncontrada = null;
    @Autowired
    private CuentasDB cuentasDB;
    public String obtenerSaldo(String cuenta) {
        cuentaEncontrada = cuentasDB.getCuenta(Integer.parseInt(cuenta));
        return "El saldo de la cuenta es: " + cuentaEncontrada.obtenerSaldo();
    }

    public String depositar(String cuenta, BigDecimal monto) {
        cuentaEncontrada = cuentasDB.getCuenta(Integer.parseInt(cuenta));
        if(cuentaEncontrada == null){
            return "La cuenta no existe";
        }
        if(monto.compareTo(BigDecimal.ZERO) <= 0){
            return "El monto a depositar debe ser mayor a cero";
        }else{
            cuentaEncontrada.deposito(monto);
        }
        return "El saldo luego del deposito es: " + cuentaEncontrada.obtenerSaldo();
    }

    public String retirar(String monto, BigDecimal cuenta) {
        cuentaEncontrada = cuentasDB.getCuenta(Integer.parseInt(cuenta));
        if(cuentaEncontrada == null){
            return "La cuenta no existe";
        }
        if(monto.compareTo(BigDecimal.ZERO) <= 0){
            return "El monto a retirar debe ser mayor a cero";
        }else{
            if(cuentaEncontrada.obtenerSaldo().compareTo(monto) < 0){
                return "No hay fondos suficientes";
            }
            cuentaEncontrada.retiro(monto);
        }
        return "El saldo luego del retiro es : " + cuentaEncontrada.obtenerSaldo();
    }
}
