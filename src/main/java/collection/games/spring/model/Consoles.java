package collection.games.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Consoles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // hibernate cria uma sequencia de dados nunca da conflito registro novo
													
	private Long id;
	private String console;
	private String fabricante;
	private String lancamento;
	private String tipoMidia;
	private String geracao;
	
	@OneToMany(mappedBy = "consoles", orphanRemoval = true , fetch = FetchType.EAGER)
	private List<Games>games;
	
	
	public List<Games> getGames() {
		return games;
	}
	public void setGames(List<Games> games) {
		this.games = games;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getLancamento() {
		return lancamento;
	}
	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}
	public String getTipoMidia() {
		return tipoMidia;
	}
	public void setTipoMidia(String tipoMidia) {
		this.tipoMidia = tipoMidia;
	}
	public String getGeracao() {
		return geracao;
	}
	public void setGeracao(String geracao) {
		this.geracao = geracao;
	}

	
	
}