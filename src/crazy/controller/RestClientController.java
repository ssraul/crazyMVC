package crazy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


@RestController//¡¡Importante poner los datos de RestController
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
	
	@RequestMapping(value = "/listapedidos", method=RequestMethod.GET)//es un segundo filtro
	public List<Order> obtenerListadoPedidosCliente(@RequestParam String email) {
		
		Client c = clientService.getClient(email);			
		List<Order>listaPedidos = new ArrayList<Order>();
		listaPedidos = orderService.listOrders(email);
			  
		return listaPedidos;
	}
	
	
	//devuelve los datos en Json
	@GetMapping(value = {"/clienthat/{email}/json"}, produces="application/json;charset=UTF-8")
	public ClientWrapper obtenerClienteHatJson(@PathVariable String email){
		Client c = clientService.getClient(email);
		ClientWrapper cw = new ClientWrapper(c);
		Link selfLink = linkTo(RestClientController.class).slash(email).withSelfRel();
		Link lnkClientes = linkTo(methodOn(RestClientController.class).obtenerListaCliente()).withRel("Lista_Clientes");
		Link lnkPedidos = linkTo(methodOn(RestClientController.class).obtenerListadoPedidosCliente(email)).withRel("Listado_pedidos");
		cw.add(selfLink);		
		cw.add(lnkClientes);
		cw.add(lnkPedidos);
		return cw;		
	}
	
	
	//devuelve los datos en xml
	@GetMapping(value = {"/clienthat/{email}/xml"}, produces="application/xml;charset=UTF-8")
	public ClientWrapper obtenerClienteHatXml(@PathVariable String email){
		Client c = clientService.getClient(email);
		ClientWrapper cw = new ClientWrapper(c);
		Link selfLink = linkTo(RestClientController.class).slash(email).withSelfRel();
		Link lnkClientes = linkTo(methodOn(RestClientController.class).obtenerListaCliente()).withRel("Lista_Clientes");
		Link lnkPedidos = linkTo(methodOn(RestClientController.class).obtenerListadoPedidosCliente(email)).withRel("Listado_pedidos");
		cw.add(selfLink);		
		cw.add(lnkClientes);
		cw.add(lnkPedidos);
		return cw;		
	}
	
	

}


