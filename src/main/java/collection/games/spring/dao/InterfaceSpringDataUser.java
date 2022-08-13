package collection.games.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import collection.games.spring.model.Consoles;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<Consoles, Long> {

}
