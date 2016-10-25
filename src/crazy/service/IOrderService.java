package crazy.service;

import java.util.List;

import crazy.model.Order;

public interface IOrderService {
	
	public List<Order> listOrders(String email);

}
