package biblioteca;

public class Utente {
	
	private String nome;
	private String cognome;
	private int numeroPrestiti;
	
	public Utente(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getNumeroPrestiti() {
		return numeroPrestiti;
	}
	public void setNumeroPrestiti(int numeroPrestiti) {
		this.numeroPrestiti = numeroPrestiti;
	}
}