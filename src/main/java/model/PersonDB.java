package model;

public class PersonDB {
	
	private int id;
	private String name;
	private int age;
	private String address;
	private String email;
	
	public PersonDB() {
		super();
	}

	public PersonDB(int id, String name, int age, String address, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
	}
	
	public PersonDB(String name, int age, String address, String email) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
