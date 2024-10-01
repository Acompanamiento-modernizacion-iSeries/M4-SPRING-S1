package com.bancolombia.gestioncuentas.app.Controllers;

import com.bancolombia.gestioncuentas.app.LogicaNegocio.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    // Obtener el saldo de una cuenta
    @GetMapping("/saldo")
    public ResponseEntity<Double> obtenerSaldo(@RequestParam String numeroCuenta) {
        return cuentaService.obtenerCuenta(numeroCuenta)
                .map(cuenta -> ResponseEntity.ok(cuenta.getSaldo()))
                .orElse(ResponseEntity.badRequest().build());
    }

    // Hacer un depósito en la cuenta
    @PostMapping("/deposito")
    public ResponseEntity<String> depositar(@RequestParam String numeroCuenta, @RequestParam double monto) {
        cuentaService.depositar(numeroCuenta, monto);
        return ResponseEntity.ok("Depósito realizado con éxito");
    }

    // Retirar dinero de la cuenta
    @PostMapping("/retiro")
    public ResponseEntity<String> retirar(@RequestParam String numeroCuenta, @RequestParam double monto) {
        boolean exito = cuentaService.retirar(numeroCuenta, monto);
        if (exito) {
            return ResponseEntity.ok("Retiro realizado con éxito");
        } else {
            return ResponseEntity.badRequest().body("Saldo insuficiente o cuenta no encontrada");
        }
    }
}
