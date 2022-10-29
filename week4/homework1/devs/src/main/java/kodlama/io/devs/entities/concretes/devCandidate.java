package kodlama.io.devs.entities.concretes;

public class devCandidate {
	private int id;
	private String devCandidateName;
	private int age;
	private int city;
	
	public devCandidate() {
	}
	
	public devCandidate(int id, String devCandidateName, int age, int city) {
		this.id = id;
		this.devCandidateName = devCandidateName;
		this.age = age;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDevCandidateName() {
		return devCandidateName;
	}


	public void setDevCandidateName(String devCandidateName) {
		this.devCandidateName = devCandidateName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getCity() {
		return city;
	}


	public void setCity(int city) {
		this.city = city;
	}

}
