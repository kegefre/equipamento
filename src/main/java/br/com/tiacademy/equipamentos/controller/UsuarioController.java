package br.com.tiacademy.equipamentos.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.equipamentos.core.crud.CrudController;
import br.com.tiacademy.equipamentos.domain.Usuario;
import br.com.tiacademy.equipamentos.service.UsuarioService;

@RestController
@RequestMapping("/usuario")

public class UsuarioController extends CrudController<Usuario, Long> {
    @Autowired
    UsuarioService service;

    @GetMapping("/hql/{nome}")
    public ResponseEntity<Usuario> hql(@PathVariable("nome") String nome) {
        Usuario usuario = service.hql(nome);
        if (Objects.isNull(usuario)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/nativa/{nome}")
    public ResponseEntity<Usuario> nativa() {
        return ResponseEntity.ok(service.nativa());
    }

    @GetMapping("/springdata/{nome}")
    public ResponseEntity<Usuario> springData(@PathVariable("nome") String nome) {

        Usuario usuario = service.springData(nome);
        if (Objects.isNull(usuario)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);

    }
}
