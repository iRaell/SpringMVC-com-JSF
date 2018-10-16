package br.com.programacaoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.programacaoweb.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
