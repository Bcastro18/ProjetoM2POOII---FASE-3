package sistema.service;

import java.util.List;

import sistema.dao.MultiplaEscolhaDAO;
import sistema.modelos.MultiplaEscolha;

public class MultiplaEscolhaService {
	
	
	MultiplaEscolhaDAO multDAO = new MultiplaEscolhaDAO();
	
	public MultiplaEscolha salvar(MultiplaEscolha mult){
		
		mult = multDAO.save(mult);
		multDAO.closeEntityManager();
		return mult;
		
	}
	public List <MultiplaEscolha> getMultiplaEscolhaes()
	{
		List <MultiplaEscolha> list = multDAO.getAll(MultiplaEscolha.class);
		multDAO.closeEntityManager();
		return list;
	}
	
	public void alterar(MultiplaEscolha mult) {
		multDAO.save(mult);
		multDAO.closeEntityManager();
	}
	
	public void remover(MultiplaEscolha mult) {
		
		mult = multDAO.getById(MultiplaEscolha.class, mult.getCodPergunta());
		multDAO.remove(mult);
		multDAO.closeEntityManager();
	}
	public MultiplaEscolha pesquisar(MultiplaEscolha mult) {

		mult = multDAO.getById(MultiplaEscolha.class, mult.getCodPergunta());
		multDAO.closeEntityManager();
		return mult;
	}
	
}
