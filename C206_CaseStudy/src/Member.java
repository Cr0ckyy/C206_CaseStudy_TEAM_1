public class Member {
	private String name;
	private String gender;
	private int mobile;
	private String email;
	private String dateOfbirth;
	private String countryOfresidence;
	private String password;

	public Member(String name, String gender, int mobile, String email, String dateOfbirth, String countryOfresidence,
			String password) {
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.dateOfbirth = dateOfbirth;
		this.countryOfresidence = countryOfresidence;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public String getCountryOfresidence() {
		return countryOfresidence;
	}

	public void setCountryOfresidence(String countryOfresidence) {
		this.countryOfresidence = countryOfresidence;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}