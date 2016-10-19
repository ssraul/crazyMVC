package crazy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	//@RequestMapping(value = {"/","/lista"}, method=RequestMethod.GET)//para que se habra llamando a diferentes RequestMapping
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
	@RequestMapping(value = {"/","/lista"}, method=RequestMethod.GET)//es un segundo filtro
	public String obtenerListaClientes(Model model) {
		List<Client>listado;
		listado=clientService.getClientList();
		model.addAttribute("listadoClientes",listado);	
		return "clientes";

	}
	
	@RequestMapping(value = {"/nuevoCliente"}, method=RequestMethod.GET)//Para crear alta de clientes, solo devuelve una vista
	public String addClient(Model model){
		//te hace un cliente vacio para que no haya error
		model.addAttribute("cliente", new Client());
		return "clienteForm";
	}
	
	@RequestMapping(value = {"/borrarcliente"}, method=RequestMethod.GET)//Para crear alta de clientes, solo devuelve una vista
	public String deleteClient(Model model, @RequestParam() String email){
		String borrado = "OK";
		clientService.deleteClient(email);	
		model.addAttribute("validacion", borrado);
		
		return "clienteForm";
	}
	

	/*
	@RequestMapping(value = {"/saveclient"}, method=RequestMethod.POST)//Para crear alta de clientes, solo devuelve una vista
	public String salvarCliente(Model model, @RequestParam Map<String, String> misDatos){		
		//validaciones y enviar a la base de datos				
		String nombre = misDatos.get("nombre");
		String apellido = misDatos.get("apellido");
		String email = misDatos.get("email");
		String insercion = "Cliente insertado correctamente";
				
		//1.validacion de datos


		
		
		//2.insertar en base de datos
		
		
		if(!clientService.addClient(nombre, apellido, email)){
			insercion = "Error al grabar datos";
		}
		
		
		misDatos.put("insercion", insercion);
				
		model.addAttribute("datos", misDatos);
		model.addAttribute("nombre",nombre);
		model.addAttribute("apellido",apellido);
		model.addAttribute("email",email);
		model.addAttribute("insercion",insercion);
		
		//varias maneras de devolver el resultado
		return obtenerListaClientes(model);
		//return "redirect:lista";
		//return "clienteForm";
	}	
	*/
	
	
	/**
	 * Ejemplo 4 mejor manera de añadir cliente, los name del formulario tienen que tener
	 * los mismos que la clase cliente name, surname, email. solo con el @ModelAttribute
	 * @param model
	 * @param cliente
	 * @return
	 */	
	@RequestMapping(value = {"/saveclient"}, method=RequestMethod.POST)
	public String salvarCliente(Model model, @Valid @ModelAttribute(name="cliente") Client cliente,
			BindingResult result){
		
		//si hay errores en el formulario, lo redirigimos la formulario otra vez
		if(result.hasErrors()){
			return "clienteForm";
		}
		
				
		
		//1.obtener los datos
		String nombre = cliente.getName();
		String apellido = cliente.getSurname();
		String email = cliente.getEmail();
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("apellido",apellido);
		model.addAttribute("email",email);
		
		//2.hacemos las validaciones
		

		
		
		//3.hacemos la inserción en la base de datos
		if(!clientService.addClient(nombre, apellido, email)){
			
		}
		
		return obtenerListaClientes(model);
		//return "clienteForm";
		//return "redirect:lista";
	}
	
	@ModelAttribute
	public void ejemplo(Model model){
		model.addAttribute("mensaje","crazy aplication");
	}
	
	
	
		
}
