package br.com.programacaoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.programacaoweb.model.TipoContato;


@Repository
public interface TipoContatoRepository extends JpaRepository<TipoContato, Integer>{
	
	

}
