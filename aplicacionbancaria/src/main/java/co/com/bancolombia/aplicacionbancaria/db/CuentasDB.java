package co.com.bancolombia.aplicacionbancaria.db;

import co.com.bancolombia.aplicacionbancaria.cuentas.Cuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentasDB {

    private final List<Cuenta> LISTA_CUENTAS = new ArrayList<>(
            List.of(
                new Cuenta("1234567890", new BigDecimal(21000)),
                new Cuenta("1122334455", new BigDecimal(12000)),
                new Cuenta("1112223334", new BigDecimal(25000))
            )
    );

    public Cuenta buscarCuenta(String numCuenta) {
        for (Cuenta cuenta : LISTA_CUENTAS) {
            if (cuenta.consultarNumCuenta().equals(numCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}
