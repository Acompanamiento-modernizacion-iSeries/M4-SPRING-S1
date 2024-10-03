package com.bancolombia.aplicacionbancaria.controller;

import com.bancolombia.aplicacionbancaria.CuentaDB.CuentaDb;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private CuentaDb cuentaDb = new CuentaDb();

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo(@RequestParam Integer cuenta){
        return cuentaDb.BuscarCuenta(cuenta).getSaldo();
    }


    //carga informacion por body
    @PostMapping("/deposito")
    public String DepositarSaldo(@RequestParam Integer cuenta, BigDecimal monto){
        if(cuentaDb.BuscarCuenta(cuenta).deposito(monto)){
            return "Deposito realizado con exito";
        }else {
            return "No se permiten valores negativos o depositos de $0";
        }
    }

    @PostMapping("/retiro")
    public String RetiroSaldo(@RequestParam Integer cuenta, BigDecimal monto){
        if(cuentaDb.BuscarCuenta(cuenta).retiro(monto) == 0){
            return "Retiro realizado con exito";
        } else if (cuentaDb.BuscarCuenta(cuenta).retiro(monto) == 1) {
            return "Monto superior a saldo disponible";
        }else {
            return "No se permiten valores negativos o retiros de $0";
        }
    }
}
