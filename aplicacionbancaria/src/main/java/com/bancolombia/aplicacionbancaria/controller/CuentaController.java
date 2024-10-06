package com.bancolombia.aplicacionbancaria.controller;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bancolombia.aplicacionbancaria.cuentas.Cuenta;
import com.bancolombia.aplicacionbancaria.db.CuentasDB;

@RestController
@RequestMapping("/{cuenta}")
public class CuentaController {

    private Cuenta cuentaEncontrada = null;

    @Autowired
    private CuentasDB cuentasDB;

    @GetMapping("/saldo")
    public String obtenerSaldo(@RequestParam String cuenta) {
        cuentaEncontrada = cuentasDB.obtenerCuenta(Integer.parseInt(cuenta));
        if(cuentaEncontrada == null){
            return "La cuenta no existe";
        }
        return "El saldo de la cuenta es: " + cuentaEncontrada.obtenerSaldo();
    }

    @PostMapping("/deposito/{monto}")
    public String depositar(@RequestParam String cuenta, BigDecimal monto) {
        cuentaEncontrada = cuentasDB.obtenerCuenta(Integer.parseInt(cuenta));
        if(cuentaEncontrada == null){
            return "La cuenta no existe";
        }
        if(monto.compareTo(BigDecimal.ZERO) <= 0){
            return "El monto a depositar debe ser mayor a cero";
        }else{
            cuentaEncontrada.deposito(monto);
        }
        return "El nuevo saldo es: " + cuentaEncontrada.obtenerSaldo();
    }

    @PostMapping("/retiro/{monto}")
    public String retirar(@RequestParam BigDecimal  monto, @RequestParam String cuenta) {
        cuentaEncontrada = cuentasDB.obtenerCuenta(Integer.parseInt(cuenta));
        if(cuentaEncontrada == null){
            return "La cuenta no existe";
        }
        if(monto.compareTo(BigDecimal.ZERO) <= 0){
            return "El monto a retirar debe ser mayor a cero";
        }else{
            if(cuentaEncontrada.obtenerSaldo().compareTo(monto) < 0){
                return "fondos insuficientes";
            }
            cuentaEncontrada.retiro(monto);
        }
        return "El nuevo saldo es : " + cuentaEncontrada.obtenerSaldo();
    }

}
