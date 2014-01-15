
public class Gäst {
	private String Name;
	private String Adress;
	private String Email;
	private int phoneNumber;
	
	public Gäst(String Name, String Adress, String Email, int phoneNumber){
		this.Name = Name;
		this.Adress = Adress;
		this.Email = Email;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;	
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
