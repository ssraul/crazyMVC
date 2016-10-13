package crazy.service;

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

}
