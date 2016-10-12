package uni26092016;

import java.util.ArrayList;
import java.util.List;

public class Corso implements ValiditaDati{
	
	private String nome;
	private int ore;
	private List<Studente> elencoStudentiCorso = new ArrayList <Studente> ();
	private List<Docente> elencoDocentiCorso = new ArrayList <Docente> ();
	
	public Corso(String nome, int ore) {
		super();
		this.setNome(nome);
		this.setOre(ore);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getOre() {
		return ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}

	@Override
	public boolean isValid() {
		if(Util.valueIsEmpty(getNome()) && getOre()>0){
			
			return true;
		}
		return false;
	}

	public List<Studente> getElencoStudentiCorso() {
		return elencoStudentiCorso;
	}

	public void setElencoStudentiCorso(List<Studente> elencoStudentiCorso) {
		this.elencoStudentiCorso = elencoStudentiCorso;
	}

	public List<Docente> getElencoDocentiCorso() {
		return elencoDocentiCorso;
	}

	public void setElencoDocentiCorso(List<Docente> elencoDocentiCorso) {
		this.elencoDocentiCorso = elencoDocentiCorso;
	}
	
	
	
	

}
