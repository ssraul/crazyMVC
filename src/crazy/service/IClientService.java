package crazy.service;

import java.util.List;

import crazy.model.Client;

public interface IClientService {
	
	
	Client getClient(String email);	
	List<Client> getClientList();
	public boolean addClient(String nombre, String apellido, String email); 
	public boolean deleteClient(String email);
	
}
