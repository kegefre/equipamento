package br.com.tiacademy.equipamentos.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.equipamentos.DTO.RegistroDTO;
import br.com.tiacademy.equipamentos.core.crud.CrudConverter;
import br.com.tiacademy.equipamentos.domain.Registro;

@Component
public class RegistroConverter implements CrudConverter<Registro, RegistroDTO> {
    @Override
    public RegistroDTO entidadeParaDto(Registro entidade) {
        return new RegistroDTO(entidade.getId(), entidade.getData_s(), entidade.getData_s(), entidade.getSituacao(), entidade.getEquipamento(), entidade.getUsuario() );
    }

    @Override
    public Registro dtoParaEntidade(RegistroDTO dto) {
        return new Registro(dto.getId(), dto.getData_s(), dto.getData_e(), dto.getSituacao(), dto.getEquipamento(), dto.getUsuario());
    }
}