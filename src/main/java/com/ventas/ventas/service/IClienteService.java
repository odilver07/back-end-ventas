package com.ventas.ventas.service;

import java.util.List;
import java.util.Optional;
import com.ventas.ventas.model.Clientes;

public interface IClienteService {
	
	List<Clientes> findAll();
	Optional<Clientes> findById(Integer id);
	Clientes create(Clientes clientes);
	Clientes update(Clientes clientes);
	void delete(Integer id);

}
