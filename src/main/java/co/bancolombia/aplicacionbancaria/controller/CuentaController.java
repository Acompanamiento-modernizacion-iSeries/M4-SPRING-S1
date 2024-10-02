package co.bancolombia.aplicacionbancaria.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    private BigDecimal saldo = new BigDecimal("1000.00");

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo() {
        return saldo;
    }
// el nombre de la variable :monto debe ser igual al q recibe el metodo

    /*
        //enviar informacion por parametro
        @GetMapping ("/deposito/{monto}")
        public String depositar(@PathVariable BigDecimal monto) {
            if (monto.compareTo(BigDecimal.ZERO) > 0){
                saldo = saldo.add(monto);
                return "Nuevo saldo: " + saldo ;
            }else {
                return "El valor debe ser mayor q cero" ;
            }
        }
    */
    //enviar informacion por cuerpo (body)
    @PostMapping("/deposito")
    public String depositar(@RequestParam BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(monto);
            return "Nuevo saldo: " + saldo;
        } else {
            return "El valor debe ser mayor q cero";
        }
    }
}
