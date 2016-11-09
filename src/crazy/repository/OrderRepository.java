package crazy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import crazy.model.Order;

public interface OrderRepository extends CrudRepository<Order, String>{
	List<Order> findAllByEmail(String email);
}
