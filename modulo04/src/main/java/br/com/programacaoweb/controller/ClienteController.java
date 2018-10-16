package br.com.programacaoweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.programacaoweb.model.Cliente;
import br.com.programacaoweb.model.Contato;
import br.com.programacaoweb.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

//@ManagedBean(name="clienteReposit")
@ViewScoped
@Named
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Setter @Getter
	private List<Cliente> clientes;

	@Setter @Getter
	private Cliente cliente = new Cliente();
	
	
    @Setter @Getter
	private boolean modoEdicao = false;
	
    @Getter @Setter
	private Contato contato = new Contato();

	@PostConstruct
	public void init() {
		clientes = clienteRepository.buscarTodos();
	}

	public void salvar() {
  try {
		clienteRepository.save(cliente);// é colocado no Banco de Dados
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Sucesso!", "Operação realizada com Sucesso!"));
		
           }catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Cliente não foi salvo!"));
		}	
	
		if (!modoEdicao)
			clientes.add(cliente); // É colocado na lista
		cliente = new Cliente(); // É gerado um novo Cliente após realizar cadastro: "É instãnciado um novo
									// Cliente"
		modoEdicao = false;

	}

	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
		clientes.remove(cliente);
	}

	public void editar(Cliente cliente) {
		setCliente(cliente);
		modoEdicao = true;

	}

	public void cancelar() {
		cliente = new Cliente();
		setModoEdicao(false);

	}

	public void adicionarContato() {		
		
		contato.setCliente(cliente); // Coloca cliente dentro do Contato
		cliente.getContatos().add(contato); // É adicionado dentro da Lista
		contato = new Contato(); // Após ad um novo contato, se inicia novamente um novo formulario pra receber novamente
		

	}
	
	public void excluirContato(Contato contato) {
		cliente.getContatos().remove(contato);
		
	}
	

}
