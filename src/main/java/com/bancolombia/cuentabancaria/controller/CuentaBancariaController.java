package com.bancolombia.cuentabancaria.controller;

import com.bancolombia.cuentabancaria.entitys.CuentaBancariaEntity;
import com.bancolombia.cuentabancaria.repository.CuentasBancariasBD;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/cuenta")
public class CuentaBancariaController {

    private CuentasBancariasBD cuentasBancariasBD;

    @GetMapping(path = "/saldo")
    public ResponseEntity<Map<String, Object>> saldo(@RequestParam String cuenta){
        Map<String, Object> message = new HashMap<>();
        message.put("saldo", cuentasBancariasBD.getCuenta(cuenta).getSaldo());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(path = "/deposito")
    public ResponseEntity<Map<String, Object>> deposito(@RequestParam BigDecimal valor, @RequestParam String cuenta){
        Map<String, Object> message = new HashMap<>();
        CuentaBancariaEntity cuentaEntity = cuentasBancariasBD.getCuenta(cuenta);
        if(!validSaldo(valor)){
            message.put("message", "El valor no puede ser negativo");
        }else{
            cuentaEntity.deposito(valor);
            message.put("message", "Deposito exitoso");
            message.put("saldo", cuentaEntity.getSaldo());
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(path = "/retiro")
    public ResponseEntity<Map<String, Object>> retiro(@RequestParam BigDecimal valor, @RequestParam String cuenta){
        Map<String, Object> message = new HashMap<>();
        CuentaBancariaEntity cuentaEntity = cuentasBancariasBD.getCuenta(cuenta);
        if(!validSaldo(valor)){
            message.put("message", "El valor no puede ser negativo");
        }else{
            cuentaEntity.retiro(valor);
            message.put("message", "Retiro exitoso");
            message.put("saldo", cuentaEntity.getSaldo());
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    private boolean validSaldo(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) < 0){
            return false;
        }
        return true;
    }
}
