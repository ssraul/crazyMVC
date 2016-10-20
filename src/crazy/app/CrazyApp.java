package crazy.app;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.*;
import javax.validation.ValidatorFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;
import crazy.model.Client;
import crazy.service.ClientService;
import crazy.service.IClientService;

public class CrazyApp {

	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("app-ctx.xml"); 
		//IClientService cs = (IClientService) appCtx.getBean(ClientService.class);		
		//Client c = cs.getClient("aaa@kk.com");
		
		//1. creamos un validador
		Validator validador;
		
		//2.cremos un validador por defecto
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validador = validatorFactory.getValidator();
		
		//3.Creamos el cliente
		Client n = new Client();
		n.setName("select * from where 1=1");
		n.setSurname("apellido");
		n.setEmail("Raul@gmail.com");
	
		
		//4.validamos el cliente
		validador.validate(n);
		 Set<ConstraintViolation<Client>> listaErrores = validador.validate(n);
		 

		 
		 Client dos = new Client();
			dos.setName("sun");
			dos.setSurname("apellido");
			dos.setEmail("Raul@gmail.com");
			validador.validate(dos);
			
			listaErrores.addAll(validador.validate(dos));
			
			 for (ConstraintViolation<Client> error: listaErrores){
				 System.out.println(error.getPropertyPath()+": "+ error.getMessage());
			 }
			
		
		//System.out.println(c.getName());
		//System.out.println(c.getSurname());
		//System.out.println(c.getEmail());
	}

}
