package co.bancolombia.controller;
import co.bancolombia.datacuenta.DataCuentas;
import co.bancolombia.model.CuentaBanco;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @GetMapping("/saldo/{nroCuenta}")
    public String obtenerSaldo(@PathVariable String nroCuenta) {
        CuentaBanco cuenta = DataCuentas.buscarCuenta(nroCuenta);
        if (cuenta != null) {
            return "El saldo de la cuenta número: " +nroCuenta+ " es: $" +cuenta.getSaldo();
        } else {
            return "Cuenta no encontrada";
        }
    }

    @PostMapping("/deposito/{nroCuenta}/{monto}")
    public String depositar(@PathVariable String nroCuenta, @PathVariable BigDecimal monto) {
        CuentaBanco cuenta = DataCuentas.buscarCuenta(nroCuenta);
        if (cuenta != null) {
            if (monto.compareTo(BigDecimal.ZERO) > 0){
                cuenta.depositar(monto);
                return "Deposito exitoso! "+ "Número de cuenta:"+nroCuenta+" Nuevo saldo :$" + cuenta.getSaldo();
            } else {
                return "El monto a depositar debe ser mayor a cero";
            }
        } else {
            return "Cuenta no encontrada";
        }
    }

    @PostMapping("/retiro/{nroCuenta}/{monto}")
    public String retirar(@PathVariable String nroCuenta, @PathVariable BigDecimal monto) {
        CuentaBanco cuenta = DataCuentas.buscarCuenta(nroCuenta);
        if (cuenta != null) {
            if (monto.compareTo(BigDecimal.ZERO) > 0){
                if (cuenta.getSaldo().compareTo(monto) >= 0) {
                    cuenta.retirar(monto);
                    return "Retiro exitoso! "+ "Cuenta Nro "+nroCuenta+" Nuevo saldo :$" + cuenta.getSaldo();
                } else {
                    return "Saldo insuficiente";
                }
            } else {
                return "El monto a retirar debe ser mayor a cero";
            }
        } else {
            return "Cuenta no encontrada";
        }
    }
}
