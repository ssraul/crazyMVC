package crazy.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import crazy.model.Client;
import crazy.service.ClientService;
import crazy.service.IClientService;

public class CrazyApp {

	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("app-ctx.xml"); 
		IClientService cs = (IClientService) appCtx.getBean(ClientService.class);		
		Client c = cs.getClient("aaa@kk.com");
		System.out.println(c.getName());
		System.out.println(c.getSurname());
		System.out.println(c.getEmail());
	}

}
