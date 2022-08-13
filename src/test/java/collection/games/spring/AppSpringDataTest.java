package collection.games.spring;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import collection.games.spring.dao.InterfaceSpringDataUser;
import collection.games.spring.model.Consoles;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;

	// Cadastrar
	@Test
	public void testeInsert() {

		Consoles consoles = new Consoles();

		consoles.setConsole("Super Nintendo");
		consoles.setFabricante("Nintendo");
		consoles.setGeracao("4");
		consoles.setLancamento("1990");
		consoles.setTipoMidia("Cartucho");

		interfaceSpringDataUser.save(consoles);

		System.out.println("Usuario cadastrado = " + interfaceSpringDataUser.count());
	}

//Consultar

	@Test
	public void testeConsultar() {

		Optional<Consoles> consoles = interfaceSpringDataUser.findById(1L);

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

		Optional<Consoles> consoles = interfaceSpringDataUser.findById(1L);
		
		Consoles data = consoles.get();

		data.setConsole("Super Nintendo");
		data.setFabricante("Nintendo");
		data.setGeracao("4");
		data.setLancamento("1990");
		data.setTipoMidia("Cartucho");

		interfaceSpringDataUser.save(data);

	}
	
//Deletar
	@Test
	public void testeDelete() {
		Optional<Consoles> consoles = interfaceSpringDataUser.findById(1l);
		
		interfaceSpringDataUser.delete(consoles.get());
	}

}
