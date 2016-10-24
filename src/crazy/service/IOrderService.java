package crazy.service;

import java.util.List;

import crazy.model.Order;

public interface IOrderService {
	
	List<Order> getOrderList(String Email);

}
