package crazy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import crazy.dao.IClientDAO;
import crazy.model.Client;

@Component
public class ClientService implements IClientService {
	@Autowired
	IClientDAO clientDao;
	
	@Override
	public Client getClient(String email) {
		return clientDao.getCliente(email);
	}


	@Override
	public List<Client> getClientList() {		
		return clientDao.getClientList();
	}


	@Override
	public boolean addClient(String nombre, String apellido, String email) {		
		return clientDao.addClient(nombre, apellido, email);
	}


	@Override
	public boolean deleteClient(String email) {
		return clientDao.deleteClient(email);
	}


	@Override
	public boolean addClientFull(Client cliente) {	
		return  clientDao.addClientFull(cliente);
	}


	
	
	
	
}
