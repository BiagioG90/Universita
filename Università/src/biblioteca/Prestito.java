package biblioteca;

import java.util.Date;

public class Prestito {
	
	private Libro libro1;
	private Utente utente1;
	private Date dataPrestito;
	private Date dataRestituzione;
	
	public Prestito() {
		
	}

	public Prestito(Libro l1, Utente u1, Date dataPrestito, Date dataRestituzione) {
		
		this.libro1 = l1;
		this.utente1 = u1;
		this.dataPrestito = dataPrestito;
		this.dataRestituzione = dataRestituzione;
		
	}

	public Libro getLibro1() {
		return libro1;
	}

	public void setLibro1(Libro libro1) {
		this.libro1 = libro1;
	}

	public Utente getUtente1() {
		return utente1;
	}

	public void setUtente1(Utente utente1) {
		this.utente1 = utente1;
	}

	public Date getDataPrestito() {
		return dataPrestito;
	}

	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}
}