package app;

public class User {
	
	//Creamos variables de atributos del usuario en privado
	private String username;
	private String name;
	private String nif;
	private String email;
	private String address;
	private String birthdate;
	private String role;
	
	//Creamos "Constructor" (método especial que se ejecuta al crear usuario)
	public User(String username, String name, String nif, String email, String address, String birthdate,
			String role) {
		//(this.x=)->
		this.username = username;
		this.name = name;
		this.nif = nif;
		this.email = email;
		this.address = address;
		this.birthdate = birthdate;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public String getNif() {
		return nif;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public String getRole() {
		return role;
	}
}