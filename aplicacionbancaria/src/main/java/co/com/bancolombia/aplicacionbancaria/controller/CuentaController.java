package co.com.bancolombia.aplicacionbancaria.controller;

import co.com.bancolombia.aplicacionbancaria.db.CuentasDB;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentasDB CUENTAS_DB = new CuentasDB();

    @GetMapping("/saldo")
    public BigDecimal saldo(@RequestParam String cuenta) {
        return CUENTAS_DB.buscarCuenta(cuenta).consultarSaldo();
    }

    @PostMapping("/deposito")
    public String deposito(@RequestParam String cuenta, @RequestParam BigDecimal monto) {
        if (CUENTAS_DB.buscarCuenta(cuenta).deposito(monto))
            return "Deposito realizado con éxito! " +
                    "- Nuevo saldo: $" + CUENTAS_DB.buscarCuenta(cuenta).consultarSaldo();
        else
            return "El monto debe ser mayor a cero!";
    }

    @PostMapping("/retiro")
    public String retiro(@RequestParam String cuenta, @RequestParam BigDecimal monto) {
        if (CUENTAS_DB.buscarCuenta(cuenta).retiro(monto))
            return "Retiro realizado con éxito! " +
                    "- Nuevo saldo: $" + CUENTAS_DB.buscarCuenta(cuenta).consultarSaldo();
        else
            return "El monto debe ser mayor a cero o no tiene fondos suficientes!";
    }
}
