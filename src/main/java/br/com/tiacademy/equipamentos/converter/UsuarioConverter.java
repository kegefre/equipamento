package br.com.tiacademy.equipamentos.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.equipamentos.DTO.UsuarioDTO;
import br.com.tiacademy.equipamentos.core.crud.CrudConverter;
import br.com.tiacademy.equipamentos.domain.Usuario;

@Component
public class UsuarioConverter implements CrudConverter<Usuario, UsuarioDTO>{
    @Override
    public UsuarioDTO entidadeParaDto(Usuario entidade) {
        return new UsuarioDTO(entidade.getId(), entidade.getUsuario());
    }

    @Override
    public Usuario dtoParaEntidade(UsuarioDTO dto) {
        return new Usuario(dto.getId(), dto.getUsuario());
    }
}
