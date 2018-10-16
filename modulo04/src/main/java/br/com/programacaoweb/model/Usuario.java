package br.com.programacaoweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length=50, nullable=false)
	private String nome;
	
	@Column(length=32,nullable=false)
	private String senha;
	
	@Column(length=50, nullable=false)
	private String papel;
	

}
