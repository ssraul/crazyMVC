package crazy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import crazy.dao.IOrderDAO;
import crazy.model.Order;

@Component
public class OrderService implements IOrderService{
	
	
	@Autowired
	IOrderDAO OrderDao;

	@Override
	public List<Order> listOrders(String email) {
		return OrderDao.listOrders(email);
	}


}
