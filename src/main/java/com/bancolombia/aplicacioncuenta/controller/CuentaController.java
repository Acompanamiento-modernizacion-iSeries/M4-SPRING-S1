package com.bancolombia.aplicacioncuenta.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.aplicacioncuenta.model.Cuenta;
import com.bancolombia.aplicacioncuenta.repository.CuentasDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @GetMapping("/saldo")
    public String obtenerSaldo(@RequestParam String cuentaId) {
        Optional<Cuenta> cuenta = buscarCuentaPorId(cuentaId);
        if (cuenta.isPresent()) {
            return "Saldo de la cuenta " + cuentaId + ": " + cuenta.get().getSaldo();
        } else {
            return "Cuenta no encontrada";
        }
    }

    @PostMapping("/deposito")
    public String depositar(@RequestParam String cuentaId, @RequestParam BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            return "El monto debe ser mayor que cero";
        }

        Optional<Cuenta> cuenta = buscarCuentaPorId(cuentaId);
        if (cuenta.isPresent()) {
            cuenta.get().setSaldo(cuenta.get().getSaldo().add(monto));
            return "Depósito exitoso. Saldo actual de la cuenta " + cuentaId + ": " + cuenta.get().getSaldo();
        } else {
            return "Cuenta no encontrada";
        }
    }

    @PostMapping("/retiro")
    public String retirar(@RequestParam String cuentaId, @RequestParam BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            return "El monto debe ser mayor que cero";
        }

        Optional<Cuenta> cuenta = buscarCuentaPorId(cuentaId);
        if (cuenta.isPresent()) {
            if (cuenta.get().getSaldo().compareTo(monto) >= 0) {
                cuenta.get().setSaldo(cuenta.get().getSaldo().subtract(monto));
                return "Retiro exitoso. Saldo actual de la cuenta " + cuentaId + ": " + cuenta.get().getSaldo();
            } else {
                return "Saldo insuficiente";
            }
        } else {
            return "Cuenta no encontrada";
        }
    }

    private Optional<Cuenta> buscarCuentaPorId(String cuentaId) {
        return CuentasDB.cuentas.stream().filter(c -> c.getId().equals(cuentaId)).findFirst();
    }
}
