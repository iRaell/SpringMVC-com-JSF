package br.com.programacaoweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor  // Construtor com argumento
@NoArgsConstructor // Construtor padrão
public class Contato {

	@Id
	@GeneratedValue
	private Integer id;
	
    @Column(length=50, nullable=false)
	private String descricao;

	@JoinColumn
	@ManyToOne
	private Cliente cliente;

	@JoinColumn
	@ManyToOne // Vários Contatos pode estar vinculados com um TipoContato
	private TipoContato tipoContato;
	
}
