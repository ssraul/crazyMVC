package crazy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

//Utilizamos la interfaz validator de java para hacer validaciones
//tenemos dos libreria que tenemos que importar hibernate validator engine y javax,validation
//las validaciones se hacen en el interior de cada modelo
//DTO data transfer object, para pasar datos con diferentes modelos juntos



@Entity
@Table(name="clientes")
public class Client {
	
	@Pattern(regexp = "^[A-Za-z]{3,30}$", message ="Nombre tiene que ser en 3 y 30 caracteres")
	//@NotNull(message = "Nombre no puede ser nulo")
	//@Size(min=3, max=30, message ="Nombre tiene que ser mayor de 3 y menor de 30")
	@Column(name="nombre")
	String name;
	
	@Pattern(regexp = "^[A-Za-z]{3,30}$", message ="Apellido tiene que ser en 3 y 30 caracteres")
	//@NotNull(message = "apellido no puede ser nulo")
	//@Size(min=3, max=30, message ="apellido tiene que ser mayor de 3 y menor de 30")
	@Column(name="apellido")
	String surname;
	
	@JacksonXmlProperty(localName="Direccion_de_Correo")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message ="Email no valido")
	//@NotNull(message = "El email no puede ser nulo")
	//@Email(message="Error sintasis de email")
	@Id
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
