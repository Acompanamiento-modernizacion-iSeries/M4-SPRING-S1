package com.bancolombia.aplicacionbancaria.controller;

import com.bancolombia.aplicacionbancaria.model.Cuenta;
import com.bancolombia.aplicacionbancaria.repository.CuentasDB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @GetMapping("/{numeroCuenta}/saldo")
    public ResponseEntity<?> obtenerSaldo(@PathVariable String numeroCuenta) {
        Cuenta cuentaEncontrada = null;
        for (Cuenta cuenta : CuentasDB.cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                cuentaEncontrada = cuenta;
                break;
            }
        }

        if (cuentaEncontrada != null) {
            return ResponseEntity.ok(cuentaEncontrada.getSaldo());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuenta no encontrada");
        }
    }

    @GetMapping("/{numeroCuenta}/depositourl/{monto}")
    public ResponseEntity<?> despositar(@PathVariable String numeroCuenta, @PathVariable BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El monto a depositar debe ser mayor a cero");
        }

        Cuenta cuentaEncontrada = null;
        for (Cuenta cuenta : CuentasDB.cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                cuentaEncontrada = cuenta;
                break;
            }
        }

        if (cuentaEncontrada != null) {
            cuentaEncontrada.setSaldo(cuentaEncontrada.getSaldo().add(monto));
            return ResponseEntity.ok(cuentaEncontrada.getSaldo());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuenta no encontrada");
        }
    }

    @PostMapping("/{numeroCuenta}/depositobody")
    public ResponseEntity<?> despositarbody(@PathVariable String numeroCuenta, @RequestParam BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El monto a depositar debe ser mayor a cero");
        }

        Cuenta cuentaEncontrada = null;
        for (Cuenta cuenta : CuentasDB.cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                cuentaEncontrada = cuenta;
                break;
            }
        }

        if (cuentaEncontrada != null) {
            cuentaEncontrada.setSaldo(cuentaEncontrada.getSaldo().add(monto));
            return ResponseEntity.ok(cuentaEncontrada.getSaldo());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuenta no encontrada");
        }
    }

    @PostMapping("/{numeroCuenta}/retirarbody")
    public ResponseEntity<?> retirarbody(@PathVariable String numeroCuenta, @RequestParam BigDecimal monto) {
        Cuenta cuentaEncontrada = null;
        for (Cuenta cuenta : CuentasDB.cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                cuentaEncontrada = cuenta;
                break;
            }
        }

        if (cuentaEncontrada != null) {
            if (monto.compareTo(cuentaEncontrada.getSaldo()) > 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insuficiente para realizar el retiro");
            }
            cuentaEncontrada.setSaldo(cuentaEncontrada.getSaldo().subtract(monto));
            return ResponseEntity.ok(cuentaEncontrada.getSaldo());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuenta no encontrada");
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearCuenta(@RequestBody Cuenta nuevaCuenta) {
        if (nuevaCuenta == null ||
                nuevaCuenta.getNumeroCuenta() == null || nuevaCuenta.getNumeroCuenta().isEmpty() ||
                nuevaCuenta.getNombre() == null || nuevaCuenta.getNombre().isEmpty() ||
                nuevaCuenta.getTipoCuenta() == null || nuevaCuenta.getTipoCuenta().isEmpty() ||
                nuevaCuenta.getSaldo() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Información de la cuenta incompleta o inválida");
        }

        List<Cuenta> cuentas = new ArrayList<>(CuentasDB.cuentas);
        cuentas.add(nuevaCuenta);
        CuentasDB.cuentas = cuentas;
        return ResponseEntity.status(HttpStatus.CREATED).body("Cuenta creada exitosamente");
    }

}
