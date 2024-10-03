package com.bancolombia.aplicacionbancaria.cuenta;

import org.springframework.stereotype.Service;

@Service
public class CuentaOperaciones {
    private CuentaDB cuentaDB;

    public CuentaOperaciones(CuentaDB cuentaDB) {
        this.cuentaDB = cuentaDB;
    }

    public double consultarSaldo(String numeroCuenta) {
        Cuenta cuenta = cuentaDB.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            return cuenta.getSaldo();
        }
        throw new IllegalArgumentException("La cuenta no existe.");
    }

    public void depositar(String numeroCuenta, double monto) {
        Cuenta cuenta = cuentaDB.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            cuenta.depositar(monto);
        } else {
            throw new IllegalArgumentException("La cuenta no existe.");
        }
    }

    public void retirar(String numeroCuenta, double monto) {
        Cuenta cuenta = cuentaDB.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            if (!cuenta.retirar(monto)) {
                throw new IllegalArgumentException("Saldo insuficiente.");
            }
        } else {
            throw new IllegalArgumentException("La cuenta no existe.");
        }
    }
}

