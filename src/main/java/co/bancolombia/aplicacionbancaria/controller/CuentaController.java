package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.DB.CuentaDB;
import co.bancolombia.aplicacionbancaria.model.Cuenta;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/cuenta")
public class CuentaController {

    @GetMapping("/saldo/{nroCuenta}")
    public String obtenerSaldo(@PathVariable String nroCuenta) {
        Cuenta cuenta = CuentaDB.buscarCuenta(nroCuenta);
        if (cuenta == null) {
            return "¡La cuenta consultada no existe en el Sistema!";
        }
        return "Cuenta Nro. " + nroCuenta
                + "\nSaldo: $" + cuenta.consultarSaldo();
    }

    //Depositar a una cuenta.
    @PostMapping("/deposito/{nroCuenta}/{monto}")
    public String depositar(@PathVariable String nroCuenta, @PathVariable BigDecimal monto) {
        Cuenta cuenta = CuentaDB.buscarCuenta(nroCuenta);
        if (cuenta == null) {
            return "¡La cuenta sobre la que se desea realizar depósito no existe!";
        }
        if (!(monto.compareTo(BigDecimal.ZERO) > 0)){
            return "¡El monto a depositar debe ser mayor a cero!";
        }
        cuenta.deposito(monto);
        return "¡Depósito exitoso! "
                + " \nCuenta número: " + nroCuenta
                + " \nNuevo saldo: $" + cuenta.consultarSaldo();
    }

    @PostMapping("/retiro/{nroCuenta}/{monto}")
    public String retirar(@PathVariable String nroCuenta, @PathVariable BigDecimal monto) {
        Cuenta cuenta = CuentaDB.buscarCuenta(nroCuenta);
        if (cuenta == null) {
            return "¡La cuenta sobre la que se desea realizar retiro no existe!";
        }
        if (!(monto.compareTo(BigDecimal.ZERO) > 0)){
            return "¡El monto a retirar debe ser mayor a cero!";
        }
        if (!(cuenta.consultarSaldo().compareTo(monto) >= 0)) {
            return "¡Saldo insuficiente para retiro!";
        }
        cuenta.retiro(monto);
        return "¡Retiro exitoso! "
                + " \nCuenta número: " + nroCuenta
                + " \nNuevo saldo: $" + cuenta.consultarSaldo();
    }
}
