package crazy.dao;

import java.util.List;

import crazy.model.Order;

public interface IOrderDAO {
	
	
	public List<Order> listOrders(String email);
	
	

}
