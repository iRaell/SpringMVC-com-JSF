package br.com.programacaoweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.programacaoweb.model.TipoContato;
import br.com.programacaoweb.repository.TipoContatoRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class TipoContatoController {

	@Autowired
	private TipoContatoRepository tipoContatoRepository;

	@Getter @Setter
	private List<TipoContato> tipoContatos;

	@PostConstruct
	public void init() {

		tipoContatos = tipoContatoRepository.findAll();

	}

	

}
