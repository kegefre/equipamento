package br.com.tiacademy.equipamentos.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.equipamentos.DTO.EquipamentoDTO;
import br.com.tiacademy.equipamentos.core.crud.CrudConverter;
import br.com.tiacademy.equipamentos.domain.Equipamento;

@Component
public class EquipamentoConverter implements CrudConverter<Equipamento, EquipamentoDTO>{
    @Override
	public EquipamentoDTO entidadeParaDto(Equipamento entidade) {
		return new EquipamentoDTO(entidade.getId(), entidade.getEquipamento());
	}

	@Override
	public Equipamento dtoParaEntidade(EquipamentoDTO dto) {
		return new Equipamento(dto.getId(), dto.getEquipamento(),0,0);
	}
}
