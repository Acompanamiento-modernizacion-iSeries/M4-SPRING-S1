package com.bancolombia.aplicacionbancaria.bd;

import com.bancolombia.aplicacionbancaria.entity.Cuenta;
import com.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class DataLoader {

    @Autowired
    private CuentaRepository cuentaRepository;

    @PostConstruct
    public void cargarDatos() {
        cuentaRepository.save(new Cuenta(1358L, BigDecimal.valueOf(5000)));
        cuentaRepository.save(new Cuenta(2468L, BigDecimal.valueOf(3000)));
        cuentaRepository.save(new Cuenta(1379L, BigDecimal.valueOf(15000)));
        cuentaRepository.save(new Cuenta(8942L, BigDecimal.valueOf(73000)));
    }
}
