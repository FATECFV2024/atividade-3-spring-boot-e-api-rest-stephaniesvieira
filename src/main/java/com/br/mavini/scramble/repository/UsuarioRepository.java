package com.br.mavini.scramble.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.mavini.scramble.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
	
	List<Usuario> findByDeletedFalseOrderByCreationDate();
	
	Usuario findByIdAndDeletedFalse(UUID id);
	
}
