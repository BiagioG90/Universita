package testMain;

import biblioteca.GestioneBiblioteca;
import biblioteca.Libro;
import biblioteca.UtenteGiaEsiste;
import uni26092016.Corso;
import uni26092016.Docente;
import uni26092016.Segreteria;
import uni26092016.Studente;
import uni26092016.Universita;

public class TestUniversita {

	public static void main(String[] args) throws UtenteGiaEsiste {
		Universita uni = new Universita("Università degli Studi di Torino", "Biblioteca Torino");
		System.out.println("Nome università: " +uni.getNome());

		Segreteria segreteria = new Segreteria();
		Studente s1 = segreteria.registraStudente(uni, "", "");
		Studente s2 = segreteria.registraStudente(uni, "Mario", "Rossi");
		if(s1==null){
			System.out.println("Studente non valido. Registrazione annullata");
		}else{
			System.out.println(s1.getNome() + " " + s1.getCognome() + ", " + "Studente valido. Registrazione effettuata");
		}
		if(s2==null){
			System.out.println("Studente non valido. Registrazione annullata");
		}else{
			System.out.println(s2.getNome() + " " + s2.getCognome() + ", " + "Studente valido. Registrazione effettuata");
		}
		Docente d1 = segreteria.registraDocente(uni, "", "", "");
		Docente d2 = segreteria.registraDocente(uni, "Angelo", "Celentano", "angcle");
		if(d1==null){
			System.out.println("Docente non valido. Registrazione annullata");
		}else{
			System.out.println(d1.getNome() + " " + d1.getCognome() + ", " + d1.getCodiceFiscale() + " " + "Docente valido. Registrazione effettuata");
		}
		if(d2==null){
			System.out.println("Docente non valido. Registrazione annullata");
		}else{
			System.out.println(d2.getNome() + " " + d2.getCognome() + " " + d2.getCodiceFiscale() + ", " + "Docente valido. Registrazione effettuata");
		}
		Corso c1 = segreteria.registraCorso(uni, "Statistica", 60);
		Corso c2 = segreteria.registraCorso(uni, "", 0);
		if(c1==null){
			System.out.println("Corso non valido. Registrazione annullata");
		}else{
			System.out.println(c1.getNome() + " " + c1.getOre() + " ore, " + "Corso valido. Registrazione effettuata");
		}
		if(c2==null){
			System.out.println("Corso non valido. Registrazione annullata");
		}else{
			System.out.println(c2.getNome() + " " + c2.getOre() + " ore, " + "Corso valido. Registrazione effettuata");
		}
		
		if(segreteria.aggiungiDocenteAlCorso(uni, d2, c1)){
			System.out.println("Docente aggiunto al corso");
		}else{
			System.out.println("Docente NON aggiunto al corso");
		}
		if(segreteria.aggiungiDocenteAlCorso(uni, d2, c2)){
			System.out.println("Docente aggiunto al corso");
		}else{
			System.out.println("Docente NON aggiunto al corso");
		}
		if(segreteria.aggiungiStudenteAlCorso(uni, s2, c1)){
			System.out.println("Studente aggiunto al corso");
		}else{
			System.out.println("Studente NON aggiunto al corso");
		}
		if(segreteria.aggiungiStudenteAlCorso(uni, s1, c1)){
			System.out.println("Studente aggiunto al corso");
		}else{
			System.out.println("Studente NON aggiunto al corso");
		}
		GestioneBiblioteca g = new GestioneBiblioteca();
		g.registraLibro(uni.getB(), "cuore", "deamicis", "123", 10);
		g.registraUtente(uni.getB(), s2.getNome(), s2.getCognome());
		Libro l = new Libro("cuore", "deamicis", "123", 10);
		if(segreteria.prestaLibro(uni, s2, l)){
			System.out.println("Libro prestato");
		}else{
			System.out.println("Prestito non riuscito");
		}
		l = new Libro("fasdf", "sdf", "13", 2);
		if(segreteria.prestaLibro(uni, s2, l)){
			System.out.println("Libro prestato");
		}else{
			System.out.println("Prestito non riuscito");
		}
		
	}

}