package crazy.dao;

import java.util.List;

import crazy.model.Client;

public interface IClientDAO {
	
	public Client getCliente(String email);	
	public List<Client> getClientList(); 
	
}
