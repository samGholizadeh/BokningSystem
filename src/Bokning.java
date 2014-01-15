
public class Bokning {
	private Gäst gäst;
	private String datum;
	
	public Bokning(Gäst gäst, String datum){
		this.gäst = gäst;
		this.datum = datum;
	}
	
	public Bokning(String datum){
		this.datum = datum;
	}

	public Gäst getGäst() {
		return gäst;
	}

	public void setGäst(Gäst gäst) {
		this.gäst = gäst;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
}
