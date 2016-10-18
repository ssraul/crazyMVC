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
import crazy.service.IClientService;

@Controller
@RequestMapping(value = "/")//es un primer filtro
public class ClientController {
	@Autowired
	IClientService clientService;
	
	
	/**
	 * ejemplo 2 para obtener datos con el @PathVariable
	 * @param email
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/client/{email}/", method=RequestMethod.GET)//es un segundo filtro
	public String obtenerClientePath(@PathVariable String email, Model model) {
		Client c = clientService.getClient(email);	
		model.addAttribute("cliente1", c);
		return "cliente";
	}
	
	
	/**
	 * ejemplo1 para obtener el email por parametros
	 * @param email
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/client", method=RequestMethod.GET)//es un segundo filtro
	public String obtenerCliente(@RequestParam() String email, Model model) {
		//@RequestParam(name="mail") String email // tambien se puede hacer asi, si tienen el mismo nombrename="mail"
		//requiered=false, el parametro no es obligatorio, o un valor por defecto defaultValue="raul@gmail.com",
		//el orden del paso de parametros es indiferente
		//si nos pasan muchos parametros lo podemos gestionar con @RequestParam Map<String, String> queryMap
		Client c = clientService.getClient(email);	
		model.addAttribute("cliente1", c);
		return "cliente";
	}
	
	/**
	 * Para obtener listado de clientes
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lista", method=RequestMethod.GET)//es un segundo filtro
	public String obtenerListaClientes(Model model) {
		List<Client>listado;
		listado=clientService.getClientList();
		model.addAttribute("listadoClientes",listado);	
		return "clientes";

	}
	
	
	
		
}
