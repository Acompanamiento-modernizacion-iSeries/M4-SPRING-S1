package com.coban.apimanejocuenta.controller;

import com.coban.apimanejocuenta.db.DbCuenta;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    private DbCuenta dbCuenta = new DbCuenta();
    private BigDecimal saldo = new BigDecimal("1000.00");


    @GetMapping("{id}/saldo")
    public BigDecimal saldo(@PathVariable("id") String id) {
        if (dbCuenta.obtenerCuenta(id) == null) {
            return new BigDecimal("-1");
        }
        return dbCuenta.obtenerCuenta(id).getSaldo();
    }
    @PostMapping("/{id}/deposito/{monto}")
    public String deposito(@PathVariable("id") String id, @PathVariable BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            if (dbCuenta.obtenerCuenta(id) == null) {
                return "La cuenta no existe.";
            }
            dbCuenta.obtenerCuenta(id).setSaldo(dbCuenta.obtenerCuenta(id).getSaldo().add(monto));
            return "Depósito exitoso. Saldo actual: " + dbCuenta.obtenerCuenta(id).getSaldo();
        } else {
            return "El monto a depositar debe ser mayor a cero.";
        }
    }

    @PostMapping("/{id}/retiro/{monto}")
    public String retiro(@PathVariable("id") String id, @PathVariable BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            if (dbCuenta.obtenerCuenta(id) == null) {
                return "La cuenta no existe.";
            }
            if (dbCuenta.obtenerCuenta(id).getSaldo().compareTo(monto) < 0) {
                return "Saldo insuficiente.";
            }
            dbCuenta.obtenerCuenta(id).setSaldo(dbCuenta.obtenerCuenta(id).getSaldo().subtract(monto));
            return "Retiro exitoso. Saldo actual: " + dbCuenta.obtenerCuenta(id).getSaldo();
        } else {
            return "El monto a retirar debe ser mayor a cero.";
        }
    }
}
