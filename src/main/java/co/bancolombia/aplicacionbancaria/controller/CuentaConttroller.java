package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.Cuenta;
import co.bancolombia.aplicacionbancaria.model.CuentasRepository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaConttroller {

    @GetMapping("/listar_cuentas")
    public List<Cuenta> listarCuentas() {
        CuentasRepository cuentas = new CuentasRepository();
        List<Cuenta> listacuentas = cuentas.listarCuentas();
        return listacuentas;
    }

    @GetMapping("/saldo/{IdCuenta}")
    public String saldo(@PathVariable("IdCuenta") String idCuenta) {
        CuentasRepository cuentasrepository = new CuentasRepository();
        Cuenta cuenta = cuentasrepository.buscarIdCuenta(idCuenta);
        if(cuenta != null){
            return "Cuenta : " + idCuenta + " \nSaldo  : " + cuenta.getSaldo();
        }
        return "La cuenta: " + idCuenta + " no existe.";
    }

    @PostMapping("/deposito/{IdCuenta}/{monto}")
    public String deposito(@PathVariable("IdCuenta") String idCuenta, @PathVariable("monto") BigDecimal monto) {
        Cuenta cuenta = new Cuenta();
        CuentasRepository cuentasrepository = new CuentasRepository();
        cuenta = cuentasrepository.buscarIdCuenta(idCuenta);
        if(cuenta != null){
            if (monto.compareTo(BigDecimal.ZERO)> 0) {
                cuenta.setSaldo(cuenta.getSaldo().add(monto));
                return "DEPOSITO EXITOSO!!! \n\nCuenta : " + idCuenta + " \nSaldo  : " + cuenta.getSaldo();
            }
            return "El valor ingresado no es valido.";
        }
        return "La cuenta: " + idCuenta + " no existe.";
    }

    @PostMapping("/retiro/{idCuenta}/{monto}")
    public String retiro(@PathVariable("idCuenta") String idCuenta, @PathVariable("monto") BigDecimal monto) {
        Cuenta cuenta = new Cuenta();
        CuentasRepository cuentasrepository = new CuentasRepository();
        cuenta = cuentasrepository.buscarIdCuenta(idCuenta);
        if(cuenta != null){
            if (monto.compareTo(BigDecimal.ZERO)> 0) {
                if(cuenta.getSaldo().compareTo(monto)> 0){
                    cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
                    return "RETIRO EXITOSO!!! \n\nCuenta : " + idCuenta + " \nSaldo  : " + cuenta.getSaldo();
                }
                return "Saldo insuficiente";
            }
            return "El valor ingresado no es valido.";
        }
        return "La cuenta: " + idCuenta + " no existe.";
    }
}
