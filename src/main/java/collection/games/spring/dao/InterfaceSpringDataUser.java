package collection.games.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import collection.games.spring.model.Consoles;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<Consoles, Long> {
	
	//Consulta Query
	@Query(value = "select p from Consoles p where p.console like %?1%")
	public List<Consoles> buscaPorConsole( String nome);
	
	//Consulta Query por parametro
	@Query(value = "select p from Consoles p where p.console = : paraconsole") //Colocar JPQL
	public Consoles buscaPorConsoleParam(@Param("paraconsole")String paraconsole);
	
	//Delete condicional
	@Modifying
	@Transactional
	@Query("delete from Consoles u where u.lancamento = ?1")
	public void deletePorLancamento(String lancamento);
	
	//Update condicional
	
	@Modifying
	@Transactional
	@Query("update Consoles u set u.lancamento = ?1 where u.console = ?2 ")
				public void updateLancamentoPorConsole(String lancamento, String console);
		
	
}

