package com.bemol.bemolapi2.api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.bemol.bemolapi2.domain.entity.Usuario;
import com.bemol.bemolapi2.domain.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> buscar (@PathVariable Long usuarioId) {
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}


}
