package com.bancolombia.aplicacionbancaria.CuentaDB;
import com.bancolombia.aplicacionbancaria.Cuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentaDb {
   private static List<Cuenta> listaCb = new ArrayList<>(
           List.of(
                   new Cuenta(1,new BigDecimal(1000.00)),
                   new Cuenta(2,new BigDecimal(2000.00))
           )
   );

    public Cuenta BuscarCuenta(Integer numCuenta){

        for (Cuenta cuenta1 : listaCb){
            if(cuenta1.getCuenta().equals(numCuenta)){
                return cuenta1;
            }
        }
        return null;
    }


}
