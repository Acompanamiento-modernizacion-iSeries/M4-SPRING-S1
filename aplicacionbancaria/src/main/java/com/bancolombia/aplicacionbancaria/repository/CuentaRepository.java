package com.bancolombia.aplicacionbancaria.repository;

import com.bancolombia.aplicacionbancaria.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
