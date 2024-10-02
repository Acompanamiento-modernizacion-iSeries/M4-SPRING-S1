package com.bancolombia.aplicacionbancaria.service;

import com.bancolombia.aplicacionbancaria.entity.Cuenta;
import com.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    // Método para consultar el saldo
    public BigDecimal consultarSaldo(Long numeroCuenta) {
        if (numeroCuenta == null || numeroCuenta <= 0) {
            return null;
        }

        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(numeroCuenta);
        if (!cuentaOpt.isPresent()) {
            return null;
        }

        return cuentaOpt.get().getSaldo();
    }

    // Método para hacer un depósito
    public boolean depositar(Long numeroCuenta, BigDecimal cantidad) {
        if (numeroCuenta == null || numeroCuenta <= 0 || cantidad == null || cantidad.compareTo(BigDecimal.ZERO) <= 0) {
            return false; // Condición inválida
        }

        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(numeroCuenta);
        if (!cuentaOpt.isPresent()) {
            return false; // Cuenta no encontrada
        }

        Cuenta cuenta = cuentaOpt.get();
        cuenta.setSaldo(cuenta.getSaldo().add(cantidad)); // Sumar al saldo existente
        cuentaRepository.save(cuenta);
        return true; // Operación exitosa
    }

    // Método para hacer un retiro
    public boolean retirar(Long numeroCuenta, BigDecimal cantidad) {
        if (numeroCuenta == null || numeroCuenta <= 0 || cantidad == null || cantidad.compareTo(BigDecimal.ZERO) <= 0) {
            return false; // Condición inválida
        }

        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(numeroCuenta);
        if (!cuentaOpt.isPresent()) {
            return false; // Cuenta no encontrada
        }

        Cuenta cuenta = cuentaOpt.get();
        if (cuenta.getSaldo().compareTo(cantidad) < 0) {
            return false; // Saldo insuficiente
        }

        cuenta.setSaldo(cuenta.getSaldo().subtract(cantidad)); // Restar el saldo
        cuentaRepository.save(cuenta);
        return true; // Operación exitosa
    }
}
