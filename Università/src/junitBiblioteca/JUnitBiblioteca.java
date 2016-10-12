package junitBiblioteca;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Biblioteca;
import biblioteca.GestioneBiblioteca;
import biblioteca.Libro;
import biblioteca.PrestitoScadutoException;
import biblioteca.Utente;
import biblioteca.UtenteGiaEsiste;

/**
 * @author feder
 *
 */
public class JUnitBiblioteca {

	static Biblioteca biblio;
	static GestioneBiblioteca gBiblio;

	
	/**
	 * costruzione iniziale di biblioteca e gestione biblioteca
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		biblio = new Biblioteca("abc");
		gBiblio = new GestioneBiblioteca();

	}

	/**
	 * * nel primo test verifico se il libro è già presente.
	 * se non è presente registro le copie.
	 */
	@Test
	public void testRegistraLibro() {
		biblio.setElencoLibri(new ArrayList<Libro>());

		String titolo = "titolo";
		String autore = "autore";
		String serialNumber = "c123";
		int copieTotali = 25;
		int copie = gBiblio.registraLibro(biblio, titolo, autore, serialNumber, copieTotali);

		for (Libro l : biblio.getElencoLibri()) {
			if (l.getTitolo().equals(titolo) && l.getAutore().equals(autore) && l.getSerialNumber().equals(serialNumber)
					&& l.getCopieDisponibili() == 25 && l.getCopieTotali() == 25) {
				assertTrue(true);
				return;
			}
		}

		fail("libro non registrato");

	}

	/**
	 * nel secondo metodo verifico che se aggiungo copie di un libro già registrato,
	 * le copie totali vengono aggiornate.
	 */
	@Test
	public void testRegistraLibro2() {
		testRegistraLibro();
		
		String titolo = "titolo";
		String autore = "autore";
		String serialNumber = "c123";
		int copieTotali = 25;

		gBiblio.registraLibro(biblio, titolo, autore, serialNumber, copieTotali);
		
		for (Libro l : biblio.getElencoLibri()) {
			if (l.getTitolo().equals(titolo) && l.getAutore().equals(autore) && l.getSerialNumber().equals(serialNumber)
					&& l.getCopieDisponibili() == 50 && l.getCopieTotali() == 50) {
				assertTrue(true);
				return;
			}
		}

		fail("copie non aggiornate");

	}
	
	/**
	 * verifico che l'utente viene registrato correttamente e che non lanci l'eccezione
	 */
	@Test
	public void testRegistraUtente() {
		biblio.setElencoUtenti(new ArrayList<Utente>());

		try {

			String nome = "nome";
			String cognome = "cognome";
			gBiblio.registraUtente(biblio, nome, cognome);

			for (Utente u : biblio.getElencoUtenti()) {
				if (u.getNome().equals(nome) && u.getCognome().equals(cognome)) {
					assertTrue(true);
					return;
				}

			}

		} catch (UtenteGiaEsiste e) {
			fail("Utente non registrato");

		}
	}
	
	/**
	 * verifica che l'utente non venga registrato due volte.
	 * nel caso avviene lancia l'eccezione.
	 */
	@Test
	public void registraUtente2() {
		testRegistraUtente();
		try {

			String nome = "nome";
			String cognome = "cognome";
			gBiblio.registraUtente(biblio, nome, cognome);
			
			fail("non viene lanciata l'eccezione");

		} catch (UtenteGiaEsiste e) {
			assertTrue(true);
		}
	}
	
	/**
	 * se ci sono copie avviene correttamente il prestito.
	 */
	@Test
	public void testPrestaLibro(){
		testRegistraUtente();
		String nome = "nome";
		String cognome = "cognome";
		String autore = "deamicis";
		String titolo = "cuore";

		int copie = gBiblio.registraLibro(biblio, titolo, autore, "a23", 1);
		boolean risultato = gBiblio.prestaLibro(biblio, titolo, autore, nome, cognome, new Date());
		
		if(risultato == true){
			assertTrue(true);
		}else{
			
			fail("prestito fallito");
		}
			
	}
	
	/**
	 * verifica che il prestito non avvenga se non ci sono copie disponibili
	 */
	@Test
	public void prestaLibro2(){
		testPrestaLibro();
		
		String nome = "nome";
		String cognome = "cognome";
		String autore = "deamicis";
		String titolo = "cuore";

		
		boolean risultato = gBiblio.prestaLibro(biblio, titolo, autore, nome, cognome, new Date());
		if(risultato == false){
			assertTrue(true);
		}else
			fail("prestito non possibile per mancanza di copie");
		
	}
	
	/**
	 * in questo test se l'utente non è registrato non può richiedere un prestito.
	 */
	@Test
	public void testPrestaLibro3(){
		
		String nome = "aaa";
		String cognome = "bbb";
		String autore = "deamicis";
		String titolo = "cuore";

		int copie = gBiblio.registraLibro(biblio, titolo, autore, "a23", 1);
		boolean risultato = gBiblio.prestaLibro(biblio, titolo, autore, nome, cognome, new Date());
		
		if(risultato == false){
			assertTrue(true);
		}else{
			
			fail("prestito fallito");
		}
			
	}
	
	/**
	 *se l'utente ha già tre prestiti attivi non può richiedere un altro prestito.
	 * @throws UtenteGiaEsiste
	 *
	 */
	@Test
	public void testPrestaLibro4() throws UtenteGiaEsiste{
		
		String nome ="biagio";
		String cognome = "gallucci";
		
		gBiblio.registraUtente(biblio, nome, cognome);
		
		gBiblio.registraLibro(biblio, "1984", "orwell", "a234", 4);
		
		boolean prestato = gBiblio.prestaLibro(biblio, "1984", "orwell", nome, cognome, new Date());
		prestato = gBiblio.prestaLibro(biblio, "1984", "orwell", nome, cognome, new Date());
		prestato = gBiblio.prestaLibro(biblio, "1984", "orwell", nome, cognome, new Date());
		if(!prestato){
			fail();
		}
		
		prestato = gBiblio.prestaLibro(biblio, "1984", "orwell", nome, cognome, new Date());
		if(prestato){
			fail();
		}
	}
	// da verificare la questione prestiti scaduti
//	@Test
//	public void testPrestaLibro5() throws ParseException{
//		testRegistraUtente();
//		testRegistraLibro();
//		String nome = "nome";
//		String cognome = "cognome";
//		String titolo = "titolo";
//		String autore = "autore";
//		
//		gBiblio.prestaLibro(biblio, titolo, autore, nome, cognome, new SimpleDateFormat("dd/MM/YYYY").parse("15/09/2016"));
//		
//		if()
		
	@Test
	public void testRestituisciLibro() throws PrestitoScadutoException{
		testRegistraUtente();
		testPrestaLibro();
		
		String nome = "nome";
		String cognome = "cognome";
		String autore = "deamicis";
		String titolo = "cuore";
		
		if(gBiblio.restituisciLibro(biblio, titolo, autore, nome, cognome)){
			assertTrue(true);
			
		}else{
			fail("non è possibile restituire");
		}
		
	}
	
	@Test
	public void testRestituisciLibro2() throws PrestitoScadutoException{
		testRestituisciLibro();
		
		String nome = "nome";
		String cognome = "cognome";
		String autore = "orwell";
		String titolo = "1984";
		
		if(gBiblio.restituisciLibro(biblio, titolo, autore, nome, cognome)){
			fail("non è possibile restituire");
			
		}else{
			assertTrue(true);
		}
		
	}
}
