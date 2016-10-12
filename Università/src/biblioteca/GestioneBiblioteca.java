package biblioteca;

import java.util.Date;
import java.util.List;

import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Prestito;
import biblioteca.PrestitoScadutoException;
import biblioteca.Utente;
import biblioteca.UtenteGiaEsiste;

public class GestioneBiblioteca {
	
	private static final int _10_GIORNI_MILLISECONDI = 10*24*60*60*1000;
	private final int NUMERO_MASSIMO_PRESTITI = 3;

	/**
	 * Registra un libro nella biblioteca. Ritorna le copie totali del libro.
	 * @param b
	 * @param titolo
	 * @param autore
	 * @param serialNumber
	 * @param copieTotali
	 * @return
	 */
	public int registraLibro(Biblioteca b, String titolo, String autore, String serialNumber, int copieTotali) {

		List<Libro> libri = b.getElencoLibri();
		for (Libro libroTemp : libri) {
			if (libroTemp.getSerialNumber().equals(serialNumber)) {
				int nuoveCopieTotali = libroTemp.getCopieTotali() + copieTotali;
				
				libroTemp.setCopieTotali(nuoveCopieTotali);
				libroTemp.setCopieDisponibili(libroTemp.getCopieDisponibili() + copieTotali);
				return nuoveCopieTotali;
			}
		}

		Libro l1 = new Libro(titolo, autore, serialNumber, copieTotali);
		libri.add(l1);

		return copieTotali;
	}

	public boolean registraUtente(Biblioteca b, String nome, String cognome) throws UtenteGiaEsiste{

		for (Utente utente : b.getElencoUtenti()) {
			if (utente.getNome().equals(nome) && utente.getCognome().equals(cognome)) {
			throw new UtenteGiaEsiste("Già Esiste");
			}else{
				return false;
			}
		}

		Utente u1 = new Utente(nome, cognome);
		b.getElencoUtenti().add(u1);
		return true;

	}

	public boolean prestaLibro(Biblioteca b, String titolo, String autore, String nome, String cognome, Date dataInizioPrestito) {

		Utente utente1 = null;

		for (Utente uTemp : b.getElencoUtenti()) {
			if (uTemp.getNome().equals(nome) && uTemp.getCognome().equals(cognome)) {
				utente1 = uTemp;
			}
		}
		if (utente1 == null) {
			return false;
		}

		Libro libro1 = null;

		for (Libro lTemp : b.getElencoLibri()) {
			if (lTemp.getAutore().equals(autore) && lTemp.getTitolo().equals(titolo)) {
				libro1 = lTemp;
			}
		}
		if (libro1 == null) {
			return false;
		}
		
		if(libro1.getCopieDisponibili() > 0){

			if(utente1.getNumeroPrestiti() < NUMERO_MASSIMO_PRESTITI){
				
				Prestito p = new Prestito(libro1, utente1, dataInizioPrestito, new Date(dataInizioPrestito.getTime() + _10_GIORNI_MILLISECONDI) );
				b.getElencoPrestiti().add(p);
				utente1.setNumeroPrestiti(utente1.getNumeroPrestiti() + 1);
				libro1.setCopieDisponibili(libro1.getCopieDisponibili() - 1);
				
				return true;
			}
		}
		return false;
	}
	
	public boolean restituisciLibro (Biblioteca b, String titolo, String autore, String nome, String cognome) throws PrestitoScadutoException{
		
		Utente utente1 = null;

		for (Utente uTemp : b.getElencoUtenti()) {
			if (uTemp.getNome().equals(nome) && uTemp.getCognome().equals(cognome)) {
				utente1 = uTemp;
			}
		}
		if (utente1 == null) {
			return false;
		}

		Libro libro1 = null;

		for (Libro lTemp : b.getElencoLibri()) {
			if (lTemp.getAutore().equals(autore) && lTemp.getTitolo().equals(titolo)) {
				libro1 = lTemp;
			}
		}
		if (libro1 == null) {
			return false;
		}
		Prestito pTemp = null;
		for (Prestito p : b.getElencoPrestiti()) {
			if (p.getUtente1().getNome().equals(utente1.getNome())
					&& p.getUtente1().getCognome().equals(utente1.getCognome())) {
				if (p.getLibro1().getAutore().equals(libro1.getAutore())
						&& p.getLibro1().getTitolo().equals(libro1.getTitolo())) {
					pTemp = p;
					if (p.getDataRestituzione().before(new Date())) {
						throw new PrestitoScadutoException();
					}
				}
			}
		}
		if(pTemp!=null){
			b.getElencoPrestiti().remove(pTemp);
			System.out.println("Prestito evaso");
			return true;
		}
		return false;
	}
}