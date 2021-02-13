package com.ventas.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.ventas.model.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes,Integer> {

}
