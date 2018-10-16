package br.com.programacaoweb.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.programacaoweb.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// connection=EmbeddedDatabaseConnection.H2
public class TestClienteRepository {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	public void tesSalvar() {

		Cliente cli = new Cliente("Jão77");
		Cliente cliSalvo = clienteRepository.save(cli);
		Assert.assertNotNull(cliSalvo.getId());

	}

	@Test
	public void testBuscarPorEmail() {
		Cliente cli = new Cliente("Jão");
		entityManager.persist(cli);
	//	Cliente cliEncontrado = clienteRepository.buscarPorEmail("joa.@hotmail.com");

	//	assertThat(cliEncontrado.getNome()).isEqualTo(cliEncontrado.getNome());
		
		System.out.println();
	//	System.out.println("nome:" + cliEncontrado.getNome());
		System.out.println();
	}

	@Test
	public void testBuscarTodos() {

		Cliente cliJao = new Cliente("Jão");
		entityManager.persist(cliJao);

		Cliente cliZe = new Cliente("Jão");
		entityManager.persist(cliZe);

		List<Cliente> lista = clienteRepository.buscarTodos();
		assertThat(lista.get(0).getNome()).isEqualTo(cliJao.getNome());
		assertThat(lista.get(1).getNome()).isEqualTo(cliZe.getNome());
		
		

	}
}
