package crazy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import crazy.model.Client;
import crazy.service.IClientService;

@Controller
@RequestMapping(value = "/")//es un primer filtro
public class ClientController {
	@Autowired
	IClientService clientService;
	@RequestMapping(value = "/client", method=RequestMethod.GET)//es un segundo filtro
	public String obtenerCliente(@RequestParam(name="mail") String email, Model model) {
		
		Client c = clientService.getClient(email);	
		model.addAttribute("cliente1", c);
		return "cliente";
	}
	
	@RequestMapping(value = "/lista", method=RequestMethod.GET)//es un segundo filtro
	public String obtenerListaClientes(Model model) {
		List<Client>listado;
		listado=clientService.getClientList();
		model.addAttribute("listadoClientes",listado);	
		return "clientes";

	}
	
	
	
		
}
