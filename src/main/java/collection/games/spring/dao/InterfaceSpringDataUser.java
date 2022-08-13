package collection.games.spring.dao;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import collection.games.spring.model.Consoles;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<Consoles, Long> {
	
	//Consulta Query
	@Query(value = "select p from Consoles p where p.console like %?1%")
	public List<Consoles> buscaPorConsole( String nome);
	
	//Consulta Query por parametro
	@Query(value = "select p from Consoles p where p.console = : paraconsole") //Colocar JPQL
	public Consoles buscaPorConsoleParam(@Param("paraconsole")String paraconsole);

}

