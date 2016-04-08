package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import sistema.modelos.Fornecedor;
import sistema.modelos.Produto;

public class FornecedorService extends Service{
	
	public void salvar(Fornecedor fornecedor)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(fornecedor);
		em.getTransaction().commit();	
	    em.close();
		
	}

	

	@SuppressWarnings("unchecked")
	public List <Fornecedor> getFornecedores()
	{
		
		List <Fornecedor > fornecedores;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select f From Fornecedor f");
		fornecedores = q.getResultList();
		em.close();
		
		return fornecedores;
	}
	
	
	public void alterar(Fornecedor fornecedor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(fornecedor);
		em.getTransaction().commit();	
	    em.close();
	}
	
	
	public void remover(Fornecedor fornecedor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			fornecedor = em.find(Fornecedor.class,fornecedor.getCodigo());
			em.remove(fornecedor);
		em.getTransaction().commit();	
	    em.close();
	}



	public Fornecedor pesquisar(Fornecedor fornecedor) {

		EntityManager em = emf.createEntityManager();
		fornecedor = em.find(Fornecedor.class,fornecedor.getCodigo());
		em.close();
	    
	    return fornecedor;
	}



	@SuppressWarnings("unchecked")
	public List<Produto> pesquisarProdutosFornecedor(Fornecedor fornecedor) {
		
		List <Produto> produtos;
		
		EntityManager em = emf.createEntityManager();
		    
		    //Torna gerenciavel a entidade
		    fornecedor = em.merge(fornecedor);
		    
		    //Atualiza a entidade para não usar dados antigos no cache do JPA
		    //Ver https://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
			em.refresh(fornecedor);
			
			
			//Recupera a lista de produtos
			produtos = fornecedor.getProdutos();
			
		em.close();
	    
	    return produtos;	
	}
	
	
	
	
	
	
	
	
	
}
