package co.bancolombia.practica1.controller;

import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentasDB cuentasDB;


    public CuentaController(CuentasDB cuentasDB) {
        this.cuentasDB = cuentasDB;
    }


    @GetMapping("/saldo/numeroCuenta/{numeroCuenta}")
    public BigDecimal getSaldo(@PathVariable String numeroCuenta) {
        Optional<Cuenta> cuenta = findCuentaByNumero(numeroCuenta);
        if (cuenta.isPresent()) {
            return cuenta.get().getSaldo();
        } else {
            throw new RuntimeException("Cuenta no encontrada.");
        }
    }

    @PostMapping("/deposito/numeroCuenta/{numeroCuenta}/cantidad/{cantidad}")
    public BigDecimal deposito(@PathVariable String numeroCuenta, @PathVariable BigDecimal cantidad) {
        Optional<Cuenta> cuenta = findCuentaByNumero(numeroCuenta);
        if (cuenta.isPresent()) {
            Cuenta c = cuenta.get();
            c.setSaldo(c.getSaldo().add(cantidad));
            return c.getSaldo();
        } else {
            throw new RuntimeException("Cuenta no encontrada.");
        }
    }

    @PostMapping("/retiro/numeroCuenta/{numeroCuenta}/cantidad/{cantidad}")
    public BigDecimal retiro(@PathVariable String numeroCuenta, @PathVariable BigDecimal cantidad) {
        Optional<Cuenta> cuenta = findCuentaByNumero(numeroCuenta);
        if (cuenta.isPresent()) {
            Cuenta c = cuenta.get();
            BigDecimal saldoActual = c.getSaldo();
            if (saldoActual.compareTo(cantidad) >= 0) {
                c.setSaldo(saldoActual.subtract(cantidad));
                return c.getSaldo();
            } else {
                throw new RuntimeException("Saldo insuficiente.");
            }
        } else {
            throw new RuntimeException("Cuenta no encontrada.");
        }
    }

    private Optional<Cuenta> findCuentaByNumero(String numeroCuenta) {
        return cuentasDB.cuentas.stream()
                .filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta))
                .findFirst();
    }
}

