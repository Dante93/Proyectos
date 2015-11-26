package conexioJavaPHP;

public class Pelicula {

	private String nom;
	private String genere;
	private String duracio;
	private String director;
	
	
	public Pelicula(String nom, String genere, String duracio, String director) {

		this.nom = nom;
		this.genere = genere;
		this.duracio = duracio;
		this.director = director;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	public String getDuracio() {
		return duracio;
	}


	public void setDuracio(String duracio) {
		this.duracio = duracio;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	@Override
	public String toString() {
		return "Pelicula [nom=" + nom + ", genere=" + genere + ", duracio="+ duracio + ", director=" + director + "]";
	}
	
	
	
}

