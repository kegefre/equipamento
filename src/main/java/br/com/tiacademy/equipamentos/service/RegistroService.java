package br.com.tiacademy.equipamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.equipamentos.core.crud.CrudService;
import br.com.tiacademy.equipamentos.domain.Equipamento;
import br.com.tiacademy.equipamentos.domain.Registro;

@Service
public class RegistroService extends CrudService<Registro, Long> {
	@Autowired
	private EquipamentoService serviceEquip;
	
	@Override
	protected Registro editarEntidade(Registro recuperado, Registro entidade) {
		recuperado.setUsuario(entidade.getUsuario());
		recuperado.setEquipamento(entidade.getEquipamento());
		recuperado.setData_s(entidade.getData_s());
		recuperado.setData_e(entidade.getData_e());
		recuperado.setSituacao(entidade.getSituacao());
		return recuperado;
	}
	
	public Registro regSaida(Registro registro) {
		Registro salvo=this.criar(registro);
		Equipamento equip = serviceEquip.porId(registro.getEquipamento().getId());
		equip.setDisponiveis(equip.getDisponiveis()-1);
		serviceEquip.editar(registro.getEquipamento().getId(),equip);
		return salvo;
	}
	
	public Registro regEntrada(Registro registro) {
		registro.setSituacao(2);
		Equipamento equip = serviceEquip.porId(registro.getEquipamento().getId());
		this.editar(registro.getId(), registro);
		equip.setDisponiveis(equip.getDisponiveis()+1);
		serviceEquip.editar(registro.getEquipamento().getId(),equip);
		return registro;
	}
	
	
}
