package com.bancolombia.aplicacionbancaria.controller;
import com.bancolombia.aplicacionbancaria.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    // Consultar el saldo
    @GetMapping("/saldo")
    public ResponseEntity<String> obtenerSaldo(@RequestParam Long numeroCuenta) {
        BigDecimal saldo = cuentaService.consultarSaldo(numeroCuenta);

        if (saldo == null) {
            if (numeroCuenta == null || numeroCuenta <= 0) {
                return new ResponseEntity<>("Número de cuenta inválido", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("La cuenta no existe", HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<>("El saldo de la cuenta es: " + saldo, HttpStatus.OK);
    }

    // Realizar un depósito
    @PostMapping("/deposito")
    public ResponseEntity<String> depositar(@RequestParam Long numeroCuenta, @RequestParam BigDecimal cantidad) {
        boolean exito = cuentaService.depositar(numeroCuenta, cantidad);

        if (!exito) {
            if (numeroCuenta == null || numeroCuenta <= 0) {
                return new ResponseEntity<>("Número de cuenta inválido", HttpStatus.BAD_REQUEST);
            } else if (cantidad == null || cantidad.compareTo(BigDecimal.ZERO) <= 0) {
                return new ResponseEntity<>("La cantidad debe ser mayor a cero", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("La cuenta no existe", HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<>("Depósito exitoso", HttpStatus.OK);
    }

    // Realizar un retiro
    @PostMapping("/retiro")
    public ResponseEntity<String> retirar(@RequestParam Long numeroCuenta, @RequestParam BigDecimal cantidad) {
        boolean exito = cuentaService.retirar(numeroCuenta, cantidad);

        if (!exito) {
            if (numeroCuenta == null || numeroCuenta <= 0) {
                return new ResponseEntity<>("Número de cuenta inválido", HttpStatus.BAD_REQUEST);
            } else if (cantidad == null || cantidad.compareTo(BigDecimal.ZERO) <= 0) {
                return new ResponseEntity<>("La cantidad debe ser mayor a cero", HttpStatus.BAD_REQUEST);
            } else if (cuentaService.consultarSaldo(numeroCuenta) != null &&
                    cuentaService.consultarSaldo(numeroCuenta).compareTo(cantidad) < 0) {
                return new ResponseEntity<>("Saldo insuficiente", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("La cuenta no existe", HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<>("Retiro exitoso", HttpStatus.OK);
    }
}
