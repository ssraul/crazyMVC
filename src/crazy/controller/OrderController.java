package crazy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import crazy.model.Client;
import crazy.model.Order;
import crazy.service.IClientService;
import crazy.service.IOrderService;

@Controller
@RequestMapping(value ="/order")
public class OrderController {
	
	@Autowired
	IClientService clientService;
	
	@Autowired
	IOrderService orderService;
	
	@RequestMapping(value = "/listorders", method=RequestMethod.GET)//es un segundo filtro
	public String obtenerListadoPedidosCliente(@RequestParam String email, Model model) {
		
		Client c = clientService.getClient(email);			
		List<Order>listaPedidos = new ArrayList<Order>();
		listaPedidos = orderService.listOrders(email);
			  
		model.addAttribute("datoscliente", c);
		model.addAttribute("listadopedidos", listaPedidos);
		return "pedidosCliente";
	}
	
	

}
