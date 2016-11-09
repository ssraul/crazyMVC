package crazy.repository;

import org.springframework.data.repository.CrudRepository;

import crazy.model.Client;

public interface ClientRepository extends CrudRepository<Client, String>{

}
