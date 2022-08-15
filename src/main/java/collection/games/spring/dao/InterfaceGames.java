package collection.games.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import collection.games.spring.model.Games;


	@Repository
	public interface InterfaceGames extends CrudRepository<Games, Long> {

	}

