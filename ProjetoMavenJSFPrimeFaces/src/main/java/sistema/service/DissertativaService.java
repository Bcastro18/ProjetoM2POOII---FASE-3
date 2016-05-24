package sistema.service;

import java.util.List;

import sistema.dao.DissertativaDAO;
import sistema.modelos.Dissertativa;

public class DissertativaService {
	
	DissertativaDAO dissertativaDAO = new DissertativaDAO();
	
	public Dissertativa salvar(Dissertativa dissertativa){
		
		dissertativa = dissertativaDAO.save(dissertativa);
		dissertativaDAO.closeEntityManager();
		return dissertativa;
		
	}
	public List <Dissertativa> getDissertativaes()
	{
		List <Dissertativa> list = dissertativaDAO.getAll(Dissertativa.class);
		dissertativaDAO.closeEntityManager();
		return list;
	}
	
	public void alterar(Dissertativa dissertativa) {
		dissertativaDAO.save(dissertativa);
		dissertativaDAO.closeEntityManager();
	}
	
	public void remover(Dissertativa dissertativa) {
		
		dissertativa = dissertativaDAO.getById(Dissertativa.class, dissertativa.getCodPergunta());
		dissertativaDAO.remove(dissertativa);
		dissertativaDAO.closeEntityManager();
	}
	public Dissertativa pesquisar(Dissertativa dissertativa) {

		dissertativa = dissertativaDAO.getById(Dissertativa.class, dissertativa.getCodPergunta());
		dissertativaDAO.closeEntityManager();
		return dissertativa;
	}
	
}
