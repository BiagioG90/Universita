package testMain;

import java.util.Date;

import biblioteca.Biblioteca;
import biblioteca.GestioneBiblioteca;
import biblioteca.PrestitoScadutoException;
import biblioteca.UtenteGiaEsiste;

public class BibliotecaTest {
	public static void main(String[] args) throws UtenteGiaEsiste, PrestitoScadutoException {
		
		GestioneBiblioteca g = new GestioneBiblioteca();
		Biblioteca b = new Biblioteca("biblio");
		System.out.println("Registrazione Libri:");
		System.out.println("Copie totali: " + g.registraLibro(b, "tttt", "aaaa", "a", 1));
		System.out.println("Copie totali: " + g.registraLibro(b, "tttt", "aaaa", "a", 1));
		System.out.println("Copie totali: " + g.registraLibro(b, "TTTT", "AAAA", "b", 1));
		System.out.println("Copie totali: " + g.registraLibro(b, "TTTT", "AAAA", "b", 1));
		System.out.println("Copie totali: " + g.registraLibro(b, "NNNN", "aaaa", "c", 1));
		System.out.println("Copie totali: " + g.registraLibro(b, "FFFF", "aaaa", "f", 1));
		System.out.println("Registrazione Utenti:");
		try{
		if (g.registraUtente(b, "Mario", "Rossi") == true) {
			System.out.println("Utente Registrato");
		} else {
			System.out.println("Utente già Registrato");
		}
		if (g.registraUtente(b, "Mario", "Rossi") == true) {
			System.out.println("Utente Registrato");
		} else {
			System.out.println("Utente già Registrato");
		}
		if (g.registraUtente(b, "Chiara", "Verdi") == true) {
			System.out.println("Utente Registrato");
		} else {
			System.out.println("Utente già Registrato");
			
		}
		}catch (Exception UtenteGiaEsiste){
			System.out.print("Eccezione risolta \n");
		}
		System.out.println("Prestito Libri: ");
		if (g.prestaLibro(b, "tttt", "aaaa", "Mario", "Rossi", new Date()) == true) {
			System.out.println("Libro prestato!");
		} else {
			System.out.println("Impossibile prestare!");
		}
		if (g.prestaLibro(b, "TTTT", "AAAA", "Mario", "Rossi", new Date()) == true) {
			System.out.println("Libro prestato!");
		} else {
			System.out.println("Impossibile prestare!");
		}
		if (g.prestaLibro(b, "NNNN", "aaaa", "Mario", "Rossi", new Date()) == true) {
			System.out.println("Libro prestato!");
		} else {
			System.out.println("Impossibile prestare!");
		}
		if (g.prestaLibro(b, "FFFF", "aaaa", "Mario", "Rossi", new Date()) == true) {
			System.out.println("Libro prestato!");
		} else {
			System.out.println("Impossibile prestare!");
		}
		if (g.prestaLibro(b, "NNNN", "aaaa", "Chiara", "Verdi", new Date()) == true) {
			System.out.println("Libro prestato!");
		} else {
			System.out.println("Impossibile prestare!");
		}
		if (g.prestaLibro(b, "FFFF", "aaaa", "Chiara", "Verdi", new Date()) == true) {
			System.out.println("Libro prestato!");
		} else {
			System.out.println("Impossibile prestare!");
		}
		System.out.println("Restituzione libri: ");
		if (g.restituisciLibro(b, "FFFF", "aaaa", "Chiara", "Verdi") == true) {
			System.out.println("Libro restituito!");
		} else {
			System.out.println("Impossibile restituire!");
		}
		if (g.restituisciLibro(b, "FFFF", "aaaa", "Chiara", "Verdi") == true) {
			System.out.println("Libro restituito!");
		} else {
			System.out.println("Impossibile restituire!");
		}
	}
}