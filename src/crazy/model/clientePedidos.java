package crazy.model;

import java.util.List;

/*
 * creamos esta clase para poder sacar por formato json, una linea donde aparezcan los datos del cliente
 * y otras lineas con la lista de pedidos y lo guardamos o envolvemos todo en un objeto
 */

public class clientePedidos {
	private Client datos;
	private List<Order> detalle;
	
	
	public clientePedidos(){
		
	}


	public clientePedidos(Client datos, List<Order> detalle) {
		super();
		this.datos = datos;
		this.detalle = detalle;
	}


	public Client getDatos() {
		return datos;
	}


	public void setDatos(Client datos) {
		this.datos = datos;
	}


	public List<Order> getDetalle() {
		return detalle;
	}


	public void setDetalle(List<Order> detalle) {
		this.detalle = detalle;
	}
	
	
	
	
	

}
