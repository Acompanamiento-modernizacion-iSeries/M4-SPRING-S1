package com.bancolombia.aplicacionbancaria.controller;


import com.bancolombia.aplicacionbancaria.cuentas.Cuenta;
import com.bancolombia.aplicacionbancaria.db.CuentasDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/{cuenta}")
public class CuentaController {

    private Cuenta cuentaEncontrada = null;

    @Autowired
    private CuentasDB cuentasDB;

    @GetMapping("/saldo")
    public String obtenerSaldo(@RequestParam String cuenta) {
        cuentaEncontrada = cuentasDB.getCuenta(Integer.parseInt(cuenta));
        if(cuentaEncontrada == null){
            return "La cuenta no existe";
        }
        return "El saldo de la cuenta es: " + cuentaEncontrada.obtenerSaldo();
    }

    @PostMapping("/deposito/{monto}")
    public String depositar(@RequestParam String cuenta, BigDecimal monto) {
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

    @PostMapping("/retiro/{monto}")
    public String retirar(@RequestParam BigDecimal  monto, @RequestParam String cuenta) {
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
