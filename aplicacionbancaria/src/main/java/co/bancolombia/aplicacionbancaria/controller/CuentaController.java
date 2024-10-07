package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/saldo/{numeroCuenta}")
    public BigDecimal obtenerSaldo(@PathVariable String numeroCuenta) {
        return cuentaService.obtenerSaldo(numeroCuenta);
    }

    @PostMapping("/deposito/{numeroCuenta}")
    public void depositar(@PathVariable String numeroCuenta, @RequestParam BigDecimal monto) {
        cuentaService.depositar(numeroCuenta, monto);
    }

    @PostMapping("/retiro/{numeroCuenta}")
    public boolean retirar(@PathVariable String numeroCuenta, @RequestParam BigDecimal monto) {
        return cuentaService.retirar(numeroCuenta, monto);
    }
}
