package com.bancolombia.sistemabancario.sistemabancario.controllers;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.sistemabancario.sistemabancario.modelos.Cuenta;
import com.bancolombia.sistemabancario.sistemabancario.repositorio.CuentasRepositorio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/cuenta")
public class CuentaConttroller {

    @GetMapping("/listar")
    public List<Cuenta> listarCuentas() {
        CuentasRepositorio cuentas = new CuentasRepositorio();
        List<Cuenta> listacuentas = cuentas.listarCuentas();
        return listacuentas;
    }
    

    @GetMapping("/saldo/{numeroCuenta}")
    public String saldo(@PathVariable("numeroCuenta") String numeroCuenta) {
        CuentasRepositorio cuentasrepo = new CuentasRepositorio();
        Cuenta cuenta = cuentasrepo.buscarPorCuenta(numeroCuenta);
        if(cuenta != null){
            return "El saldo de la cuenta: " + numeroCuenta + " es de: " + cuenta.getSaldo();
        }else{
        return "cuenta: " + numeroCuenta + " no existe en el sistema";
        }
    }

    @PostMapping("/deposito/{numeroCuenta}/{monto}")
    public String deposito(@PathVariable("numeroCuenta") String numeroCuenta, @PathVariable("monto") BigDecimal monto) {
        Cuenta cuenta = new Cuenta();
        CuentasRepositorio cuentasrepo = new CuentasRepositorio();
        cuenta = cuentasrepo.buscarPorCuenta(numeroCuenta);
        if(cuenta != null){
            if (monto.compareTo(BigDecimal.ZERO)> 0) {
                cuenta.setSaldo(cuenta.getSaldo().add(monto));
                return "Depósito realizado con exito. nuevo saldo: " + cuenta.getSaldo();
            }else{
                return "Valor del depósito debe ser mayor a cero";
            }

        }else{
           return "cuenta: " + numeroCuenta + " no existe en el sistema";
        }
    }

    @PostMapping("/retiro/{numeroCuenta}/{monto}")
    public String retiro(@PathVariable("numeroCuenta") String numeroCuenta, @PathVariable("monto") BigDecimal monto) {
        Cuenta cuenta = new Cuenta();
        CuentasRepositorio cuentasrepo = new CuentasRepositorio();
        cuenta = cuentasrepo.buscarPorCuenta(numeroCuenta);
        if(cuenta != null){
            if (monto.compareTo(BigDecimal.ZERO)> 0) {
                if(cuenta.getSaldo().compareTo(monto)> 0){
                    cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
                    ;
                    return "Retiro realizado con exito: nuevo saldo: " + cuenta.getSaldo();
                }else{
                    return "Saldo insuficiente";
                }

            }else{
                return "Valor del retiro debe ser mayor a cero";
            }

        }else{
           return "cuenta: " + numeroCuenta + " no existe en el sistema";
        }
    }
    
}
