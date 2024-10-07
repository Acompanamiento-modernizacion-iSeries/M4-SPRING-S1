package com.example.EjercicioSpringboot.Controller;

import com.example.EjercicioSpringboot.Banco.Cuenta;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private List<Cuenta> cuentas;

    public CuentaController() {
        this.cuentas = Cuenta.crearCuentas();
    }

    @GetMapping("/saldo/{numeroCuenta}")
    public BigDecimal obtenerSaldo(@PathVariable String numeroCuenta) {
        Cuenta cuenta = encontrarCuenta(numeroCuenta);
        return cuenta.getSaldo();
    }

    @PostMapping("/deposito")
    public String depositar(@RequestParam String numeroCuenta, @RequestParam BigDecimal monto) {
        Cuenta cuenta = encontrarCuenta(numeroCuenta);
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            cuenta.setSaldo(cuenta.getSaldo().add(monto));
            return "Depósito realizado. Saldo actual: $" + cuenta.getSaldo();
        } else {
            return "El monto debe ser mayor a 0";
        }
    }

    @PostMapping("/retiro")
    public String retirar(@RequestParam String numeroCuenta, @RequestParam BigDecimal monto) {
        Cuenta cuenta = encontrarCuenta(numeroCuenta);
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            if (cuenta.getSaldo().compareTo(monto) >= 0) {
                cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
                return "Retiro realizado, su saldo actual es de: $" + cuenta.getSaldo();
            } else {
                return "Saldo insuficiente";
            }
        } else {
            return "El monto debe ser mayor a 0";
        }
    }

    private Cuenta encontrarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        System.out.println("No se encontró");
        throw new RuntimeException("Cuenta no encontrada");
    }
}