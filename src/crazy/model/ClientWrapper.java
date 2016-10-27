package crazy.model;

import org.springframework.hateoas.ResourceSupport;
/*
 * Clase que utilizamos para poner links en los json y en los xml
 */
public class ClientWrapper extends ResourceSupport{

	Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientWrapper(Client client) {
		super();
		this.client = client;
	}
	
	
	
}
