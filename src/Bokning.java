
public class Bokning {
	private G�st g�st;
	private String datum;
	
	public Bokning(G�st g�st, String datum){
		this.g�st = g�st;
		this.datum = datum;
	}
	
	public Bokning(String datum){
		this.datum = datum;
	}

	public G�st getG�st() {
		return g�st;
	}

	public void setG�st(G�st g�st) {
		this.g�st = g�st;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
}
