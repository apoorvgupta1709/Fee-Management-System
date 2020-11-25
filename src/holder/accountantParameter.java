package holder;


public class accountantParameter {
	private int id;
	private String name,email,gender,contact;

	public accountantParameter() {
		super();
	}

	public accountantParameter(String name, String email,  String gender, String contact) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.contact = contact;
	}

	public accountantParameter(int id, String name, String email, String gender, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}


}
