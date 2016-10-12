package uni26092016;

import java.util.ArrayList;
import java.util.List;

import biblioteca.Biblioteca;

public class Universita {
	
	private String nome;
	private List<Studente> elencoStudenti = new ArrayList <Studente> ();
	private List<Docente> elencoDocenti = new ArrayList <Docente> ();
	private List<Corso> elencoCorsi = new ArrayList <Corso> ();
	private Biblioteca b;
	
	public Universita(String nome, String nomeBiblioteca) {
		super();
		this.setNome(nome);
		this.setB(new Biblioteca(nomeBiblioteca));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Studente> getElencoStudenti() {
		return elencoStudenti;
	}

	public void setElencoStudenti(List<Studente> elencoStudenti) {
		this.elencoStudenti = elencoStudenti;
	}

	public List<Docente> getElencoDocenti() {
		return elencoDocenti;
	}

	public void setElencoDocenti(List<Docente> elencoDocenti) {
		this.elencoDocenti = elencoDocenti;
	}

	public List<Corso> getElencoCorsi() {
		return elencoCorsi;
	}

	public void setElencoCorsi(List<Corso> elencoCorsi) {
		this.elencoCorsi = elencoCorsi;
	}

	public Biblioteca getB() {
		return b;
	}

	public void setB(Biblioteca b) {
		this.b = b;
	}
	
	

}
