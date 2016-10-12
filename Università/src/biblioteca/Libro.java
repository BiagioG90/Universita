package biblioteca;

public class Libro {
	
	private String titolo;
	private String autore;
	private String serialNumber;
    private int copieTotali;
    private int copieDisponibili;
    
    public Libro(String titolo, String autore, String serialNumber, int copieTotali) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.serialNumber = serialNumber;
		this.copieTotali = copieTotali;
		this.copieDisponibili = copieTotali;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getCopieTotali() {
		return copieTotali;
	}
	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}
	public int getCopieDisponibili() {
		return copieDisponibili;
	}
	public void setCopieDisponibili(int copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}
}