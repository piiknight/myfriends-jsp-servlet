package model.bean;

public class Contact {
	int id_contact;
	String name;
	String email;
	long phone;
	String content;

	public int getId_contact() {
		return id_contact;
	}

	public void setId_contact(int id_contact) {
		this.id_contact = id_contact;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Contact(int id_contact, String name, String email, long phone, String content) {
		super();
		this.id_contact = id_contact;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.content = content;
	}

	public Contact() {
		super();
	}

	@Override
	public String toString() {
		return "Contact [id_contact=" + id_contact + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", content=" + content + "]";
	}

}
