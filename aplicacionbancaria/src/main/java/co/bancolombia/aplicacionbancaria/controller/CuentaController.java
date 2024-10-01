package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.bd.CuentaBancariaBD;
import co.bancolombia.aplicacionbancaria.model.CuentaBancaria;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    //Obtener saldo de una cuenta.
    @GetMapping("/saldo/{nroCuenta}")
    public String obtenerSaldo(@PathVariable String nroCuenta) {
        CuentaBancaria cuenta = CuentaBancariaBD.buscarCuenta(nroCuenta);
        //validar si la cuenta existe.
        if (cuenta != null) {
            return "El saldo de la cuenta número: " +nroCuenta+ " es: $" +cuenta.consultarSaldo();
        } else {
            return "¡La cuenta consultada no existe!";
        }
    }

    //Depositar a una cuenta.
    @PostMapping("/deposito/{nroCuenta}/{monto}")
    public String depositar(@PathVariable String nroCuenta, @PathVariable BigDecimal monto) {
        CuentaBancaria cuenta = CuentaBancariaBD.buscarCuenta(nroCuenta);
        //validar si la cuenta existe.
        if (cuenta != null) {
            //validar si el monto a depositar es mayor a cero.
            if (monto.compareTo(BigDecimal.ZERO) > 0){
                cuenta.deposito(monto);
                return "¡Depósito exitoso! "+ "sobre cuenta número: "+nroCuenta+" Nuevo saldo: $" + cuenta.consultarSaldo();
            } else {
                return "¡El monto a depositar debe ser mayor a cero!";
            }
        } else {
            return "¡La cuenta sobre la que se desea realizar depósito no existe!";
        }
    }

    //Retirar de una cuenta.
    @PostMapping("/retiro/{nroCuenta}/{monto}")
    public String retirar(@PathVariable String nroCuenta, @PathVariable BigDecimal monto) {
        CuentaBancaria cuenta = CuentaBancariaBD.buscarCuenta(nroCuenta);
        //validar si la cuenta existe.
        if (cuenta != null) {
            //validar si el monto a retirar es mayor a cero.
            if (monto.compareTo(BigDecimal.ZERO) > 0){
                //validar si el saldo es suficiente para realizar el retiro.
                if (cuenta.consultarSaldo().compareTo(monto) >= 0) {
                    cuenta.retiro(monto);
                    return "¡Retiro exitoso! "+ "sobre cuenta número: "+nroCuenta+" Nuevo saldo: $" + cuenta.consultarSaldo();
                } else {
                    return "¡Saldo insuficiente para retiro!";
                }
            } else {
                return "¡El monto a retirar debe ser mayor a cero!";
            }
        } else {
            return "¡La cuenta sobre la que se desea realizar retiro no existe!";
        }
    }
}
