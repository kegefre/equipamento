package br.com.tiacademy.equipamentos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.equipamentos.DTO.EquipamentoDTO;
import br.com.tiacademy.equipamentos.core.crud.CrudController;
import br.com.tiacademy.equipamentos.domain.Equipamento;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController extends CrudController<Equipamento, EquipamentoDTO,Long>{

}
