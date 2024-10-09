package co.bancolombia.aplicacionbanco.controller;

import co.bancolombia.aplicacionbanco.service.cuentaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.math.BigDecimal;

@RestController
@RequestMapping("/numCuenta")
public class cuentaController {

    @Autowired
    private cuentaService cuentaservice;

    @GetMapping("/saldo/{numCuenta}")
    public ResponseEntity<BigDecimal> obtenerSaldo(@PathVariable(name = "numCuenta") String numCuenta) {
        if(cuentaservice.obtenerSaldo(numCuenta) != null)
            return ResponseEntity.ok().body(cuentaservice.obtenerSaldo(numCuenta));
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/deposito/{numCuenta}")
    public String depositar(@PathVariable(name = "numCuenta") String numCuenta,@RequestParam(name = "monto") BigDecimal monto) {
        return cuentaservice.depositar(numCuenta, monto);
    }


    @PostMapping("/retirar/{numCuenta}")
    public ResponseEntity<String> retirar(@PathVariable String numCuenta, @RequestParam(name = "monto") BigDecimal monto) {
        if ( (numCuenta == null) || (monto == null) )
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body(cuentaservice.retirar(numCuenta,monto));

    }
}




