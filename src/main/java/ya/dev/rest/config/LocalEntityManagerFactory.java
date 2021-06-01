package ya.dev.rest.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LocalEntityManagerFactory implements ServletContextListener{
	
	private static EntityManagerFactory emf;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		Map<String,String> properties = new HashMap<>();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		emf = Persistence.createEntityManagerFactory("crm", properties);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		emf.close();
	}
	
	// Recovery of an Entity Manager
	public static EntityManager createEntityManager() {
		if(emf == null)
			throw new IllegalStateException("Context is not initialized yet!");
		return emf.createEntityManager();
	}
	
	
}
