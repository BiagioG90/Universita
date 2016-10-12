package uni26092016;

import java.util.Date;

import biblioteca.GestioneBiblioteca;
import biblioteca.Libro;
import biblioteca.Utente;

public class Segreteria {

	private static int m = 1;

	public Segreteria() {

	}

	public Studente registraStudente(Universita u, String nome, String cognome) {

		Studente s1 = null;

		for (Studente s : u.getElencoStudenti()) {
			if (s.getNome().equals(nome) && s.getCognome().equals(cognome)) {
				s1 = s;
			}
		}
		if (s1 == null) {

			s1 = new Studente(nome, cognome, m, 0);
			if (s1.isValid()) {
				u.getElencoStudenti().add(s1);
				m++;
				return s1;
			}
		}
		return null;
	}

	public Docente registraDocente(Universita u, String nome, String cognome, String codiceFiscale) {

		Docente d1 = null;

		for (Docente d : u.getElencoDocenti()) {
			if (d.getNome().equals(nome) && d.getCognome().equals(cognome)
					&& d.getCodiceFiscale().equals(codiceFiscale)) {
				d1 = d;
			}
		}
		if (d1 == null) {
			d1 = new Docente(nome, cognome, codiceFiscale);
			if (d1.isValid()) {
				u.getElencoDocenti().add(d1);
				return d1;
			}
		}

		return null;
	}

	public Corso registraCorso(Universita u, String nome, int ore) {

		Corso c1 = null;

		for (Corso c : u.getElencoCorsi()) {
			if (c.getNome().equals(nome) && c.getOre() == ore) {
				c1 = c;
			}
		}
		if (c1 == null) {
			c1 = new Corso(nome, ore);
			if (c1.isValid()) {
				u.getElencoCorsi().add(c1);
				return c1;
			}
		}

		return null;
	}

	public boolean aggiungiStudenteAlCorso(Universita u, Studente s, Corso c) {
		if (u == null || s == null || c == null) {
			return false;
		}

		Corso c1 = null;
		for (Corso cTemp : u.getElencoCorsi()) {
			if (cTemp.getNome().equals(c.getNome())) {
				c1 = cTemp;
			}
		}
		if (c1 == null) {

			return false;
		}

		Studente s1 = null;
		for (Studente sTemp : u.getElencoStudenti()) {
			if (sTemp.getNome().equals(s.getNome()) && sTemp.getCognome().equals(s.getCognome())) {
				s1 = sTemp;
			}
		}
		if (s1 == null) {
			return false;

		}

		if (!c1.getElencoStudentiCorso().contains(s1)) {
			c1.getElencoStudentiCorso().add(s1);

			return true;

		}
		return false;
	}

	public boolean aggiungiDocenteAlCorso(Universita u, Docente d, Corso c) {
		if (u == null || d == null || c == null) {
			return false;
		}

		Corso c1 = null;

		for (Corso cTemp : u.getElencoCorsi()) {
			if (cTemp.getNome().equals(c.getNome())) {
				c1 = cTemp;
			}
		}
		if (c1 == null) {

			return false;
		}

		Docente d1 = null;

		for (Docente dTemp : u.getElencoDocenti()) {
			if (dTemp.getNome().equals(d.getNome()) && dTemp.getCognome().equals(d.getCognome())
					&& dTemp.getCodiceFiscale().equals(d.getCodiceFiscale())) {
				d1 = dTemp;
			}
		}

		if (d1 == null) {

			return false;
		}

		if (!c1.getElencoDocentiCorso().contains(d1)) {
			c1.getElencoDocentiCorso().add(d1);
			return true;
		}
		return false;
	}

	public boolean prestaLibro(Universita u, Studente s, Libro l) {
		if (u == null || s == null || l == null) {
			return false;
		}
		Studente stud1 = null;

		for (Studente s1 : u.getElencoStudenti()) {
			if (s1.getNome().equals(s.getNome()) && s1.getCognome().equals(s1.getCognome())) {
				stud1 = s1;
			}
		}
		if (stud1 == null) {
			return false;
		}
		
		GestioneBiblioteca g1 = new GestioneBiblioteca ();
		return g1.prestaLibro(u.getB(), l.getTitolo(), l.getAutore(), s.getNome(), s.getCognome(), new Date());

		
		
	}

}