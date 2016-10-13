package crazy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import crazy.model.Client;
import crazy.service.IClientService;

@Controller
@RequestMapping(value = "/")
public class ClientController {
	@Autowired
	IClientService clientService;
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String obtenerCliente(Model model) {
		Client c1 = clientService.getClient("raul@gmail.com");
		Client c2 = clientService.getClient("hector@gmail.com");
		
		model.addAttribute("cliente1", c1);
		model.addAttribute("cliente2", c2);
		model.addAttribute("saludo", "Hola a todos menos a Tomcat");
		return "cliente";
	}
}
