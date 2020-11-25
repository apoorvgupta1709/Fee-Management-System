package holder;


public class studentParameter {
	private int rollno,fee;
	private String name,email,gender,course;
	private String address,contact;
	

public studentParameter() {}

public studentParameter(String name, String email, String course,  String gender,String address,String contact) {
	super();
	this.name = name;
	this.email = email;
	this.gender = gender;
	this.course = course;

	this.address = address;
	this.contact = contact;
}

public studentParameter(int rollno, String name, String email, String course,String gender,  String address, String contact) {
	super();
	this.rollno = rollno;
	this.name = name;
	this.email = email;
	this.gender = gender;
	this.course = course;
	
	this.address = address;
	this.contact = contact;
}

public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
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
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getcontact() {
	return contact;
}
public void setcontact(String contact) {
	this.contact = contact;
}

public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}


}
