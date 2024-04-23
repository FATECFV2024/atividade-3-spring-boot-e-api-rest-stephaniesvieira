package com.br.mavini.scramble.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.mavini.scramble.model.Usuario;
import com.br.mavini.scramble.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(path = "/api")
public class IndexController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping(path = "/users")
	public List<Usuario> getUsuario() {
		List<Usuario> users = usuarioRepository.findByDeletedFalseOrderByCreationDate();
		return users;
	}
	
	@GetMapping(path = "/users/{id}")
	public Usuario getUsuarioById(@PathVariable String id) {
		Usuario users = usuarioRepository.findByIdAndDeletedFalse(UUID.fromString(id));
		return users;
	}

	@PostMapping(path = "/users")
	public Usuario getUsuario(@RequestBody MultiValueMap<String, String> form) {

		Usuario newUser = new Usuario();
		newUser.setName(form.getFirst("name"));
		newUser.setLastName(form.getFirst("last_name"));
		newUser.setDocument(form.getFirst("document"));

		return usuarioRepository.save(newUser);
	}

	@PutMapping(path = "/users")
	@Transactional
	public Usuario getUsuario(@PathVariable String id, @RequestBody MultiValueMap<String, String> form) {
		try {
			Usuario user = usuarioRepository.findByIdAndDeletedFalse(UUID.fromString(id));
			user.setName(form.getFirst("name"));
			user.setLastName(form.getFirst("last_name"));
			user.setDocument(form.getFirst("document"));

		} catch (Exception err) {
			System.out.println(err.getMessage());
			return null;
		}

		return null;
	}

	@DeleteMapping(path = "/users/{id}")
	@Transactional
	public Usuario getUsuario(@PathVariable String id) {

		Usuario user = usuarioRepository.findByIdAndDeletedFalse(UUID.fromString(id));
		user.setDeleted(true);

		return null;
	}

}
