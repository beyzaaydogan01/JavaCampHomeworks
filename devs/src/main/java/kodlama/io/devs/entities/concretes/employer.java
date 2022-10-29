package kodlama.io.devs.entities.concretes;

public class employer {
	private int id;
	String employerCompanyName;
	
	public employer() {
	}

	public employer(int id, String employerCompanyName) {
		super();
		this.id = id;
		this.employerCompanyName = employerCompanyName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployerCompanyName() {
		return employerCompanyName;
	}

	public void setEmployerCompanyName(String employerCompanyName) {
		this.employerCompanyName = employerCompanyName;
	}
	
}
