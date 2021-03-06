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
import crazy.model.Order;
import crazy.service.IClientService;
import crazy.service.IOrderService;

@Controller
@RequestMapping(value = "/client")//es un primer filtro
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
		//model.addAttribute("cliente", new Client());
		model.addAttribute("totalErrores", 0);
		model.addAttribute("listaErrores", null);	
	
		
		return "clienteForm";
	}
	
	@RequestMapping(value = {"/borrarcliente"}, method=RequestMethod.GET)//Para crear alta de clientes, solo devuelve una vista
	public String deleteClient(Model model, @RequestParam(name="email") String email){
		String borrado = "OK";
		clientService.deleteClient(email);	
		model.addAttribute("validacion", email);
		
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
	 * Ejemplo 4 mejor manera de a�adir cliente, los name del formulario tienen que tener
	 * los mismos que la clase cliente name, surname, email. solo con el @ModelAttribute
	 * @param model
	 * @param cliente
	 * @return
	 */	
	@RequestMapping(value = {"/saveclient"}, method=RequestMethod.POST)
	public String salvarCliente(Model model,@Valid @ModelAttribute(name="cliente") Client cliente,
			BindingResult result){
		
		//BindingResult result es el resultado de la validacion de Spring
		
		//@valid es el de las validaciones, es el equivalente a hacer la llamada validator, en la validacion manual
		
		//@ModelAttribute, consigue los datos de la clase entera, siempre que coincidan los nombre y la 
		//conversion de datos tambien me la hace spring.
		
		
		//si hay errores en el formulario, lo redirigimos la formulario otra vez
		//si hay errores guarda el total de errores y los manda otra vez al formulario
		if(result.hasErrors()){
			
			//todos los errores
			//model.addAttribute("errores",result);//podraimos tener solo este para tener errores
			
			model.addAttribute("totalErrores", result.getErrorCount());
			model.addAttribute("listaErrores", result.getAllErrors());
			
			
			model.addAttribute("nombre",cliente.getName());
			model.addAttribute("apellido",cliente.getSurname());
			model.addAttribute("email",cliente.getEmail());
			//model.addAttribute("pruebas",result.getFieldErrorCount("name"));
			
			return "clienteForm";
		}

				
		if(clientService.addClientFull(cliente)){
			return obtenerListaClientes(model);
		}
		
		//podemos hacer diferentes salidas de datos.
		return obtenerListaClientes(model);
		//return "clienteForm";
		//return "redirect:lista";
	}
	
	/**
	 * Modelo compartido por todas las peticiones
	 * @param model
	 */
	@ModelAttribute
	public void ejemplo(Model model){
		model.addAttribute("mensaje","crazy aplication");
	}
	
	
	
		
}
