package collection.games.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Games {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String ajogo;
	
	private String genero;
	
	private String produtora;
	
	private String ano;
	
	@ManyToOne(optional = false)
	private Consoles consoles;
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAjogo() {
		return ajogo;
	}

	public void setAjogo(String ajogo) {
		this.ajogo = ajogo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Consoles getConsoles() {
		return consoles;
	}

	public void setConsoles(Consoles consoles) {
		this.consoles = consoles;
	}
	
	
	

}
