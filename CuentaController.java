package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.basedatos.CuentaBancariabasedatos;
import co.bancolombia.aplicacionbancaria.modelo.CuentaBancaria;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @GetMapping("/saldo/{nroCuenta}")
    public String obtenerSaldo(@PathVariable String nroCuenta) {
        CuentaBancaria cuenta = CuentaBancariabasedatos.buscarCuenta(nroCuenta);
        if (cuenta != null) {
            return "Cuenta número: " +nroCuenta+ " con saldo: $" +cuenta.getSaldo();
        } else {
            return "La cuenta no existe";
        }
    }

    @PostMapping("/deposito/{nroCuenta}/{monto}")
    public String depositar(@PathVariable String nroCuenta, @PathVariable BigDecimal monto) {
        CuentaBancaria cuenta = CuentaBancariabasedatos.buscarCuenta(nroCuenta);
        if (cuenta != null) {
            if (monto.compareTo(BigDecimal.ZERO) > 0){
                cuenta.depositar(monto);
                return "Deposito exitoso. "+ "Cuenta número: "+nroCuenta+" con saldo: $" + cuenta.getSaldo();
            } else {
                return "El monto a depositar debe ser mayor a cero";
            }
        } else {
            return "La cuenta no existe";
        }
    }

    @PostMapping("/retiro/{nroCuenta}/{monto}")
    public String retirar(@PathVariable String nroCuenta, @PathVariable BigDecimal monto) {
        CuentaBancaria cuenta = CuentaBancariabasedatos.buscarCuenta(nroCuenta);
        if (cuenta != null) {
            if (monto.compareTo(BigDecimal.ZERO) > 0){
                if (cuenta.getSaldo().compareTo(monto) >= 0) {
                    cuenta.retirar(monto);
                    return "Retiro exitoso. "+ "Cuenta número:"+nroCuenta+" con saldo :$" + cuenta.getSaldo();
                } else {
                    return "Saldo insuficiente";
                }
            } else {
                return "El monto a retirar debe ser mayor a cero";
            }
        } else {
            return "La cuenta no existe";
        }
    }
}
