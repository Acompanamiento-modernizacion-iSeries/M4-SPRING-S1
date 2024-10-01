package com.bancolombia.cuentabancaria.repository;

import com.bancolombia.cuentabancaria.entitys.CuentaBancariaEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CuentasBancariasBD {

    private static Map<String, CuentaBancariaEntity> cuentaBancariaEntity = new HashMap<>();

    public static void iniciarData(){
        CuentaBancariaEntity cuenta1 = new CuentaBancariaEntity("123451", BigDecimal.valueOf(1000));
        CuentaBancariaEntity cuenta2 = new CuentaBancariaEntity("123452", BigDecimal.valueOf(3000));
        CuentaBancariaEntity cuenta3 = new CuentaBancariaEntity("123453", BigDecimal.valueOf(5000));

        cuentaBancariaEntity.put(cuenta1.getCuenta(), cuenta1);
        cuentaBancariaEntity.put(cuenta2.getCuenta(), cuenta2);
        cuentaBancariaEntity.put(cuenta3.getCuenta(), cuenta3);
    }

    public static CuentaBancariaEntity getCuenta(String cuenta){
        return cuentaBancariaEntity.get(cuenta);
    }
}
