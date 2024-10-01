package com.bancolombia.sistemabancario.sistemabancario.repositorio;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;

import com.bancolombia.sistemabancario.sistemabancario.modelos.Cuenta;

@Repository
public class CuentasRepositorio {
    
    private List<Cuenta> cuentas;
    

    public CuentasRepositorio() {
        this.cuentas = Arrays.asList(
            new Cuenta("123589693912", new BigDecimal(1500000.00)),
            new Cuenta("836493847433", new BigDecimal(6000000.00)),
            new Cuenta("909065348745", new BigDecimal(3500000.00)),
            new Cuenta("765438296403", new BigDecimal(1300000.00)));
    }

    public List<Cuenta> listarCuentas(){
        return cuentas;
    }

    public Cuenta buscarPorCuenta(String cuenta){
        return cuentas.stream().filter(p ->  p.getCuenta().equals(cuenta)).findFirst().orElse(null);

    }


}
