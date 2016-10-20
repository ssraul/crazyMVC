package crazy.model;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

//Utilizamos la interfaz validator de java para hacer validaciones
//tenemos dos libreria que tenemos que importar hibernate validator engine y javax,validation
//las validaciones se hacen en el interior de cada modelo
//DTO data transfer object, para pasar datos con diferentes modelos juntos


public class Client {
	
	@NotNull(message = "Nombre no puede ser nulo")
	@Size(min=3, max=30, message ="Nombre no cumple condiciones")
	String name;
	
	
	@NotNull(message = "apellido no puede ser nulo")
	@Size(min=3, max=30, message ="apellido no cumple condiciones")
	String surname;
	
	@NotNull(message = "El email es obligatorio.")
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
