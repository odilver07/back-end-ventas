package com.ventas.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ventas.ventas.model.Clientes;
import com.ventas.ventas.service.ClientesServiceImpl;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesServiceImpl clientesServ;
	
	@GetMapping
	public ResponseEntity<List<Clientes>> findAll(){
		return ResponseEntity.ok(clientesServ.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clientes> findById(@PathVariable("id") Integer id){
		return clientesServ.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Clientes> create( @RequestBody Clientes cliente){
		return new ResponseEntity<>(clientesServ.create(cliente), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Clientes> update(@RequestBody Clientes cliente){
		return clientesServ.findById(cliente.getIdCliente())
				.map(c -> ResponseEntity.ok(clientesServ.update(cliente)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Clientes> delete(@PathVariable("id") Integer id){
		return clientesServ.findById(id)
				.map(c -> {
					clientesServ.delete(id);
					return ResponseEntity.ok(c);
					})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
