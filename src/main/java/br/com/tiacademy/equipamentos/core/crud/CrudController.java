package br.com.tiacademy.equipamentos.core.crud;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class CrudController<T extends CrudDomain<ID>, D, ID>{
	@Autowired
	protected CrudService<T, ID> service;
	
	@Autowired
	protected CrudConverter<T, D> converter;
	
	@GetMapping("/lista")
	public ResponseEntity<List<D>> listar() {
		List<D> listaDto = service.listar().stream().map(converter::entidadeParaDto).collect(Collectors.toList());
		return ResponseEntity.ok(listaDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<D> especifico(@PathVariable("id") ID id) {

		T resultado = service.porId(id);
		if (Objects.isNull(resultado)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(converter.entidadeParaDto(resultado));
	}
	
	@PostMapping
	public ResponseEntity<D> criar(@RequestBody D dto) {
		T entidade=converter.dtoParaEntidade(dto);
		T salvo = service.criar(entidade);
		return ResponseEntity.ok(converter.entidadeParaDto(salvo));
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<D> editar(@PathVariable("id") ID id, @RequestBody D dto) {
		T entidade = converter.dtoParaEntidade(dto);
		T salvo = service.editar(id, entidade);
		return ResponseEntity.ok(converter.entidadeParaDto(salvo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") ID id) {
		service.excluir(id);
		return ResponseEntity.noContent().build();

	}
}