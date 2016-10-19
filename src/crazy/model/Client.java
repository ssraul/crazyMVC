package crazy.model;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

//Utilizamos la interfaz validator de java para hacer validaciones
//tenemos dos libreria que tenemos que importar hibernate validator engine y javax,validation


public class Client {
	
	@NotNull(message = "Este campo no puede ser nulo")
	@Size(min=3, max=30, message ="Nombre no cumple condiciones")
	String name;
	
	
	@NotNull(message = "Este campo no puede ser nulo")
	@Size(min=3, max=30, message ="Nombre no cumple condiciones")
	String surname;
	
	
	@Email(message="Error email")
	String email;
	
	
	//getters y setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
