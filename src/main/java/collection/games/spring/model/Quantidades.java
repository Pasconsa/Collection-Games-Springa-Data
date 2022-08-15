package collection.games.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Quantidades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private int quantConsoles;
	@Column(nullable = false)
	private int quantGames;
	@Column(nullable = false)
	private int quantControles;
	
	
	@ManyToOne(optional = false)
	private Consoles consoles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantConsoles() {
		return quantConsoles;
	}

	public void setQuantConsoles(int quantConsoles) {
		this.quantConsoles = quantConsoles;
	}

	public int getQuantGames() {
		return quantGames;
	}

	public void setQuantGames(int quantGames) {
		this.quantGames = quantGames;
	}

	public int getQuantControles() {
		return quantControles;
	}

	public void setQuantControles(int quantControles) {
		this.quantControles = quantControles;
	}

	public Consoles getConsoles() {
		return consoles;
	}

	public void setConsoles(Consoles consoles) {
		this.consoles = consoles;
	}
	
	
	

}
