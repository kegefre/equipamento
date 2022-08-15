package br.com.tiacademy.equipamentos.core.crud;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class CrudController<T, ID> {
	@Autowired
	protected CrudService<T, ID> service;
	
	@GetMapping
	public ResponseEntity<List<T>> listar() {

		List<T> listaEntidades = service.listar();
		return ResponseEntity.ok(listaEntidades);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T> especifico(@PathVariable("id") ID id) {

		T resultado = service.porId(id);
		if (Objects.isNull(resultado)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	public ResponseEntity<T> criar(@RequestBody T entidade) {
		T salvo = service.criar(entidade);
		return ResponseEntity.ok(salvo);
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<T> editar(@PathVariable("id") ID id, @RequestBody T entidade) {
		return ResponseEntity.ok(service.editar(id, entidade));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") ID id) {
		service.excluir(id);
		return ResponseEntity.ok().build();

	}
}