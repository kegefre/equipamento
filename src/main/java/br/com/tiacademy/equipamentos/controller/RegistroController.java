package br.com.tiacademy.equipamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.equipamentos.core.crud.CrudController;
import br.com.tiacademy.equipamentos.domain.Registro;
import br.com.tiacademy.equipamentos.service.RegistroService;

@RestController
@RequestMapping("/registro")
public class RegistroController extends CrudController<Registro, Long>{
	
	@Autowired
	RegistroService service;
	
	@PostMapping("/saida")
	public Registro regSaida(@RequestBody Registro registro) {
		return service.regSaida(registro);
	}
	
	@PutMapping("/entrada")
	public Registro regEntrada(@RequestBody Registro registro) {
		return service.regEntrada(registro);
	}
}
