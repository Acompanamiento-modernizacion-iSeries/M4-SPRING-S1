package co.banco.gestioncuenta.controller;

import co.banco.gestioncuenta.db.CuentaRepository;
import co.banco.gestioncuenta.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/{numeroCuenta}/saldo")
    public ResponseEntity<BigDecimal> obtenerSaldo(@PathVariable String numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cuenta.getSaldo());
    }

    @PostMapping("/{numeroCuenta}/deposito")
    public ResponseEntity<String> depositar(@PathVariable String numeroCuenta, @RequestParam BigDecimal monto) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.badRequest().body("El monto debe ser mayor que cero.");
        }
        cuenta.depositar(monto);
        return ResponseEntity.ok("Depósito realizado, saldo actual: " + cuenta.getSaldo());
    }

    @PostMapping("/{numeroCuenta}/retiro")
    public ResponseEntity<String> retirar(@PathVariable String numeroCuenta, @RequestParam BigDecimal monto) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.badRequest().body("El monto debe ser mayor que cero.");
        }
        if (cuenta.retirar(monto)) {
            return ResponseEntity.ok("Retiro realizado, saldo actual: " + cuenta.getSaldo());
        } else {
            return ResponseEntity.badRequest().body("Saldo insuficiente.");
        }
    }
}