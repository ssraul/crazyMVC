package crazy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crazy.model.Client;
import crazy.model.ClientWrapper;
import crazy.model.Order;
import crazy.model.clientePedidos;
import crazy.service.IClientService;
import crazy.service.IOrderService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping(value="/cliente")
public class RestClientController {
	
	@Autowired
	IClientService clientService;
	
	@Autowired
	IOrderService orderService;
	
	
	@RequestMapping(value = "/c", method=RequestMethod.GET)
	public Client obtenerClienteParam(@RequestParam String email){
		Client c= clientService.getClient(email);
		return c;
	}
	
	@RequestMapping(value = "/c/{email}/", method=RequestMethod.GET)
	public Client obtenerClientePath(@PathVariable String email){
		Client c= clientService.getClient(email);
		return c;
	}
	
	@RequestMapping(value = "/c/lista", method=RequestMethod.GET)
	public List<Client> obtenerListaCliente(){
		List<Client>listado = new ArrayList<Client>();
		listado = clientService.getClientList();
		
		return listado;
	}
	
	@RequestMapping(value = "/clientedetalle/{email}/", method=RequestMethod.GET)
	public clientePedidos obtenerClienteYPedidios(@PathVariable String email){
		
		clientePedidos nuevo = new clientePedidos();
		Client c= clientService.getClient(email);		
		nuevo.setDatos(c);		
		List<Order>listaPedidos = new ArrayList<Order>();
		listaPedidos = orderService.listOrders(email);
		nuevo.setDetalle(listaPedidos);		
		return nuevo;
	}
	
	
	@GetMapping(value = {"/clienthat/{email}/"})
	public ClientWrapper obtenerClienteHat(@PathVariable String email){
		Client c = clientService.getClient(email);
		ClientWrapper cw = new ClientWrapper(c);
		Link selfLink = linkTo(RestClientController.class).slash(email).withSelfRel();
		cw.add(selfLink);		
		return cw;

	}
	
	

}


