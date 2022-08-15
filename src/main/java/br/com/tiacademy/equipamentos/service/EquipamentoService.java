package br.com.tiacademy.equipamentos.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.equipamentos.core.crud.CrudService;
import br.com.tiacademy.equipamentos.domain.Equipamento;

@Service
public class EquipamentoService extends CrudService<Equipamento, Long> {
	@Override
	protected Equipamento editarEntidade(Equipamento recuperado, Equipamento entidade) {
		recuperado.setEquipamento(entidade.getEquipamento());
		recuperado.setQuantidade(entidade.getQuantidade());
		return recuperado;
	}
}
