package br.com.tiacademy.equipamentos.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipamentoDTO implements Serializable{

	private Long id;
	private String equipamento;
    
}
