package uni26092016;

import biblioteca.Utente;

public class Docente extends Utente implements ValiditaDati {
	
	private String codiceFiscale;

	public Docente(String nome, String cognome, String codiceFiscale) {
		super(nome, cognome);
		this.setCodiceFiscale(codiceFiscale);
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public boolean isValid() {
		if(Util.valueIsEmpty(getNome()) && Util.valueIsEmpty(getCognome()) && Util.valueIsEmpty(getCodiceFiscale())){
			return true;
		}
	return false;
	
	
	}
}
