package co.bancolombia.aplicacionbancaria.CuentaService;

import co.bancolombia.aplicacionbancaria.Cuenta.Cuenta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CuentaService {
    private Map<String, Cuenta> cuentas = new HashMap<>();

    public CuentaService() {
        cuentas.put("123", new Cuenta("123", new BigDecimal("1000.00")));
        cuentas.put("456", new Cuenta("456", new BigDecimal("2000.00")));
    }

    public BigDecimal getSaldo(String numeroCuenta) {
        return cuentas.get(numeroCuenta).getSaldo();
    }

    public String depositar(String numeroCuenta, BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) < 0) {
            return ("Error: No se permiten depósitos con valores negativos.");
        }
        Cuenta cuenta = cuentas.get(numeroCuenta);
        cuenta.setSaldo(cuenta.getSaldo().add(monto));
        return "Depósito exitoso. Saldo actual: " + cuenta.getSaldo();
    }

    public String retirar(String numeroCuenta, BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) < 0) {
            return "Error: No se permiten retiros con valores negativos.";
        }
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta.getSaldo().compareTo(monto) < 0) {
            return "Error: No se permiten saldos negativos.";
        }
        cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
        return "Retiro exitoso. Saldo actual: " + cuenta.getSaldo();
    }
}