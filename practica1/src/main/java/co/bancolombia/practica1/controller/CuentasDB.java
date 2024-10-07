package co.bancolombia.practica1.controller;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentasDB {

    public static List<Cuenta> cuentas;

    static {
        cuentas = new ArrayList<>();
        cuentas.add(new Cuenta("1", new BigDecimal("1000")));
        cuentas.add(new Cuenta("2", new BigDecimal("1000")));
        cuentas.add(new Cuenta("3", new BigDecimal("1000")));
        cuentas.add(new Cuenta("5", new BigDecimal("1000")));
        cuentas.add(new Cuenta("4", new BigDecimal("1000")));
    }
}