package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ServicePerguntasGeral {
	

	   protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoMavenJSFPrimeFaces");
	 
	   public <A> void salvar(A a)
		{
		    
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();	
				em.persist(a);
			em.getTransaction().commit();	
		    em.close();
			
		}
		
		
		@SuppressWarnings("unchecked")
		public <A> List <A> getAs()
		{
			
			List <A> as;
			
			EntityManager em = emf.createEntityManager();
			Query q = em.createQuery("Select a From A a");
			as = (List<A>)q.getResultList();
			em.close();
			
			return as;
			
		}

		public <A> void alterar(A a) {

			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();	
				em.merge(a);
			em.getTransaction().commit();	
		    em.close();
			
		}

		
		public <A> void remover(A a) 
		{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();	
		//	a = em.find(a.getClass(), a.getClass().getMatricula());
				em.remove(a);
			em.getTransaction().commit();	
		    em.close();

		}

}
