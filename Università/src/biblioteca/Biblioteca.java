package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private String nome;
	private List<Libro> elencoLibri;
	private List<Utente> elencoUtenti;
	private List<Prestito> elencoPrestiti;
	
	public Biblioteca(String nome) {
		super();
		this.nome = nome;
		this.elencoLibri = new ArrayList<Libro>();
		this.elencoUtenti = new ArrayList<Utente>();
		this.setElencoPrestiti(new ArrayList <Prestito>());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Libro> getElencoLibri() {
		return elencoLibri;
	}

	public void setElencoLibri(List<Libro> elencoLibri) {
		this.elencoLibri = elencoLibri;
	}

	public List<Utente> getElencoUtenti() {
		return elencoUtenti;
	}

	public void setElencoUtenti(List<Utente> elencoUtenti) {
		this.elencoUtenti = elencoUtenti;
	}

	public List<Prestito> getElencoPrestiti() {
		return elencoPrestiti;
	}

	public void setElencoPrestiti(List<Prestito> elencoPrestiti) {
		this.elencoPrestiti = elencoPrestiti;
	}
}