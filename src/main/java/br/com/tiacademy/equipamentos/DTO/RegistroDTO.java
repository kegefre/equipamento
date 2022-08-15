package br.com.tiacademy.equipamentos.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.tiacademy.equipamentos.domain.Equipamento;
import br.com.tiacademy.equipamentos.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroDTO implements Serializable{

	private Long id;
	private LocalDate data_s;
	private LocalDate data_e;
    private int situacao;
    
    @OneToOne
	@JoinColumn(name="equip_id", referencedColumnName = "id")
	private Equipamento equipamento;
    
    @OneToOne
	@JoinColumn(name="usuario_id", referencedColumnName = "id")
    private Usuario usuario;
      
}
