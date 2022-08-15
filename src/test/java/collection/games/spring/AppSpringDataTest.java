package collection.games.spring;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import collection.games.spring.dao.InterfaceConsoles;
import collection.games.spring.dao.InterfaceGames;
import collection.games.spring.dao.InterfaceQuantidades;
import collection.games.spring.model.Consoles;
import collection.games.spring.model.Games;
import collection.games.spring.model.Quantidades;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired
	private InterfaceConsoles interfaceConsoles;

	@Autowired
	private InterfaceGames interfaceGames;

	@Autowired
	private InterfaceQuantidades interfaceQuantidades;

	// Cadastrar
	@Test
	public void testeInsert() {

		Consoles consoles = new Consoles();

		consoles.setConsole("Atari 2600");
		consoles.setFabricante("Atari");
		consoles.setGeracao("2");
		consoles.setLancamento("1977");
		consoles.setTipoMidia("Cartucho");

		interfaceConsoles.save(consoles);

		System.out.println("Usuario cadastrado = " + interfaceConsoles.count());
	}

//Consultar

	@Test
	public void testeConsultar() {

		Optional<Consoles> consoles = interfaceConsoles.findById(6L);

		System.out.println(consoles.get().getConsole());
		System.out.println(consoles.get().getFabricante());
		System.out.println(consoles.get().getGeracao());
		System.out.println(consoles.get().getLancamento());
		System.out.println(consoles.get().getTipoMidia());
		System.out.println(consoles.get().getId());
	}

//Atualizar

	@Test
	public void testeAtualizar() {

		Optional<Consoles> consoles = interfaceConsoles.findById(6L);

		Consoles data = consoles.get();

		data.setConsole("Dreamcast");
		data.setFabricante("Sega");
		data.setGeracao("6");
		data.setLancamento("1998");
		data.setTipoMidia("Gd");

		interfaceConsoles.save(data);

	}

//Deletar
	@Test
	public void testeDelete() {
		Optional<Consoles> consoles = interfaceConsoles.findById(2l);

		interfaceConsoles.delete(consoles.get());
	}

	// Consulta por nome Query
	@Test
	public void testeConsultaNome() {
		List<Consoles> list = interfaceConsoles.buscaPorConsole("Super Nintendo");

		for (Consoles consoles : list) {
			System.out.println(consoles.getConsole());
			System.out.println(consoles.getFabricante());
			System.out.println(consoles.getGeracao());
			System.out.println(consoles.getLancamento());
			System.out.println(consoles.getTipoMidia());
			System.out.println(consoles.getId());
			System.out.println("------------------");
		}
	}

	// Consulta Query e parametros

	@Test
	public void testeConsultaNomeParam() {
		Consoles consoles = interfaceConsoles.buscaPorConsoleParam("Super");

		System.out.println(consoles.getConsole());
		System.out.println(consoles.getFabricante());
		System.out.println(consoles.getGeracao());
		System.out.println(consoles.getLancamento());
		System.out.println(consoles.getTipoMidia());
		System.out.println(consoles.getId());
		System.out.println("------------------");
	}

	// deletar por condição metodo @modYfing e @transaction
	@Test
	public void testeDeletePorLancamento() {
		interfaceConsoles.deletePorLancamento("1992");
	}

	// update por condição atualizar lancamento se console chamar.
	@Test
	public void testeUpdateFabricantePorConsole() {
		interfaceConsoles.updateLancamentoPorConsole("1990", "Super Nintendo");
	}

	// --------------------Gravar a consultar classe
	// Games------------------------------
	@Test
	public void testeGravaGames() {

		Optional<Consoles> consoles = interfaceConsoles.findById(7l);

		Games games = new Games();
		games.setAno("1996");
		games.setGenero("Luta");
		games.setAjogo("Mortal ultimate");
		games.setProdutora("Midway");
		games.setConsoles(consoles.get());

		interfaceGames.save(games);
	}

	@Test
	public void testeConsultarGames() {

		Optional<Consoles> consoles = interfaceConsoles.findById(7L);

		System.out.println(consoles.get().getConsole());
		System.out.println(consoles.get().getFabricante());
		System.out.println(consoles.get().getGeracao());
		System.out.println(consoles.get().getLancamento());
		System.out.println(consoles.get().getTipoMidia());
		System.out.println(consoles.get().getId());

		for (Games games : consoles.get().getGames()) {
			System.out.println(games.getAjogo());
			System.out.println(games.getGenero());
			System.out.println(games.getProdutora());
			System.out.println(games.getAno());
			System.out.println(games.getConsoles().getConsole());
			System.out.println("----------------------------");
		}
	}

	// --------------------Gravar a consultar classe Quantidades------------------------------
	@Test
	public void testeGravaQuantidades() {

		Optional<Consoles> consoles = interfaceConsoles.findById(8l);

		Quantidades qtd = new Quantidades();
		qtd.setQuantConsoles(3);
		qtd.setQuantGames(100);
		qtd.setQuantControles(12);
		qtd.setConsoles(consoles.get());

		interfaceQuantidades.save(qtd);
	}


	}
