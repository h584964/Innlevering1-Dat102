package no.hvl.dat102;


public class Film {
	private int filmnr;
	private String produsent;
	private String tittle;
	private int aar;
	private Sjanger sjanger;
	private String filmselskap;
	

	public Film() {
		this(0, "", "", 0, null, ""); // kaller på den neste konstruktøren

	}
	

	public Film(int filmnr, String produsent, String tittle, int aar, Sjanger sjanger, String filmselskap) {
		
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittle = tittle;
		this.aar = aar;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	

}
