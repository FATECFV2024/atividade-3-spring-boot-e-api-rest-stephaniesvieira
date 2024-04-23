package com.br.mavini.scramble.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Usuario extends Domain{

	private String name;
	private String lastName;
	private String document;
	
}
