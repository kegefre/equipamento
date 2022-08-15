package br.com.tiacademy.equipamentos.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.equipamentos.core.crud.CrudRepository;
import br.com.tiacademy.equipamentos.domain.Registro;

@Repository
public interface RegistroRepository extends CrudRepository<Registro, Long>{

}
