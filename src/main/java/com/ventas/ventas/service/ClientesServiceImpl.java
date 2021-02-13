package com.ventas.ventas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ventas.ventas.model.Clientes;
import com.ventas.ventas.repository.ClienteRepository;


@Service
public class ClientesServiceImpl implements IClienteService{
	
	@Autowired
	private ClienteRepository clienteRepo;

	@Override
	public List<Clientes> findAll() {
		return clienteRepo.findAll();
	}

	@Override
	public Optional<Clientes> findById(Integer id) {
		return clienteRepo.findById(id);
	}

	@Override
	public Clientes create(Clientes clientes) {
		return clienteRepo.save(clientes);
	}

	@Override
	public Clientes update(Clientes clientes) {
		return clienteRepo.save(clientes);
	}

	@Override
	public void delete(Integer id) {
		clienteRepo.deleteById(id);
		
	}


}
