package br.com.tiacademy.equipamentos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.equipamentos.core.crud.CrudRepository;
import br.com.tiacademy.equipamentos.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query(value = "select u from Usuario u where u.usuario like %:nome%")
    Usuario consultaPeloNome(@Param("nome") String nome);

    @Query(value = "select * from usuario u where u.usuario like '%Gil%'", nativeQuery = true)
    Usuario consultaPeloNomeNativa();

    Usuario findByUsuario(String nome);
}
