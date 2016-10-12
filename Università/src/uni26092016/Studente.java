package uni26092016;

import biblioteca.Utente;

public class Studente extends Utente implements ValiditaDati{
	
	private int matricola;
	private double media;
	
	public Studente(String nome, String cognome, int matricola, double media) {
		super(nome, cognome);
		this.setMatricola(matricola);
		this.setMedia(media);
	}

	public int getMatricola(int m) {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	@Override
	public boolean isValid() {
		if(Util.valueIsEmpty(getNome()) && Util.valueIsEmpty(getCognome())){
			return true;
	}
		return false;
	
	
	
	}
}

