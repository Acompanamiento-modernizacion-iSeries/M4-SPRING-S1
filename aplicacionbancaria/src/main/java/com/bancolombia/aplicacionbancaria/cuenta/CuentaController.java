package com.bancolombia.aplicacionbancaria.cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private CuentaOperaciones cuentaOperaciones;

    @Autowired
    public CuentaController(CuentaDB cuentaDB) {
        this.cuentaOperaciones = new CuentaOperaciones(cuentaDB);
    }

    @GetMapping("/saldo")
    public String getSaldo(@RequestParam String numeroCuenta) {
        return "El saldo de la cuenta: " + numeroCuenta + " es: " + cuentaOperaciones.consultarSaldo(numeroCuenta);
    }

    @PostMapping("/deposito")
    public void realizarDeposito(@RequestParam String numeroCuenta, @RequestParam double monto) {
        cuentaOperaciones.depositar(numeroCuenta, monto);
    }

    @PostMapping("/retiro")
    public void realizarRetiro(@RequestParam String numeroCuenta, @RequestParam double monto) {
        cuentaOperaciones.retirar(numeroCuenta, monto);
    }

}

