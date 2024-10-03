package co.bancolombia.aplicacionbancaria.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CuentasRepository {

    private List<Cuenta> cuentas;


    public CuentasRepository() {
        this.cuentas = Arrays.asList(
                new Cuenta("10",  new BigDecimal(1000), "Ahorros"),
                new Cuenta("20",  new BigDecimal(2000), "Ahorros"),
                new Cuenta("30",  new BigDecimal(3000), "Ahorros"),
                new Cuenta("40",  new BigDecimal(4000), "Ahorros"),
                new Cuenta("50",  new BigDecimal(5000), "Ahorros"),
                new Cuenta("60",  new BigDecimal(6000), "Ahorros"),
                new Cuenta("70",  new BigDecimal(7000), "Ahorros"));
    }

    public List<Cuenta> listarCuentas(){
        return cuentas;
    }

    public Cuenta buscarIdCuenta(String cuenta){
        return cuentas.stream().filter(p ->  p.getCuentaId().equals(cuenta)).findFirst().orElse(null);
    }

}


