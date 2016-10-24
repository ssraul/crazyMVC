package crazy.dao;

import java.util.List;

import crazy.model.Order;

public interface IOrderDAO {
	
	List<Order> getOrderList(String Email);

}
