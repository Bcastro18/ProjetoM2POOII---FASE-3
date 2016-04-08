package sistema.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Service {

    protected static EntityManagerFactory emf;
	
	public Service()
	{
	      emf = Persistence.createEntityManagerFactory("ProjetoMavenJSFPrimeFaces");
	}
	
}
