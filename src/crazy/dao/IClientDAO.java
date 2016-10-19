package crazy.dao;

import java.util.List;

import crazy.model.Client;

public interface IClientDAO {
	
	public Client getCliente(String email);	
	public List<Client> getClientList();
	public boolean addClient(String nombre, String apellido, String email); 
	public boolean deleteClient(String email);
	public boolean addClient(Client cliente);
	
}
