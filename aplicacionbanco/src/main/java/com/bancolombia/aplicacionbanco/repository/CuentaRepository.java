package com.bancolombia.aplicacionbanco.repository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CuentaRepository {
    List<String> listaCuentas = List.of(
            "Cuenta1",
            "Cuenta2",
            "Cuenta3"
    );

    public boolean buscarCuenta(String cuenta){
        boolean indCuenta = false;
        for (String str : listaCuentas){
            if (str.equals(cuenta)) {
                indCuenta = true;
                break;
            }
        }
        return indCuenta;
    }
}
