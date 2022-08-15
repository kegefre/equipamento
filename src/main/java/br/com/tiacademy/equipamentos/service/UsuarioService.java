package br.com.tiacademy.equipamentos.service;

import org.springframework.stereotype.Service;
import br.com.tiacademy.equipamentos.core.crud.CrudService;
import br.com.tiacademy.equipamentos.domain.Usuario;
import br.com.tiacademy.equipamentos.repository.UsuarioRepository;

@Service
public class UsuarioService extends CrudService<Usuario, Long> {

	@Override
	protected Usuario editarEntidade(Usuario recuperado, Usuario entidade) {
		recuperado.setUsuario(entidade.getUsuario());
		return recuperado;
	}

	public UsuarioRepository getRepository() {
		return (UsuarioRepository) this.repository;
	}

	public Usuario hql(String nome) {
		return this.getRepository().consultaPeloNome(nome);
	}

	public Usuario nativa() {
		return this.getRepository().consultaPeloNomeNativa();
	}

	public Usuario springData(String nome) {
		return this.getRepository().findByUsuario(nome);
	}
}
