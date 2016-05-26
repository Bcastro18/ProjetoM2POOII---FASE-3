package sistema.service;

import java.util.List;

import sistema.dao.ProvaDAO;
import sistema.modelos.Professor;
import sistema.modelos.Prova;

public class ProvaService {
	

	ProvaDAO provaDAO = new ProvaDAO();
	
	public Prova salvar(Prova prova){
		
		prova = provaDAO.save(prova);
		provaDAO.closeEntityManager();
		return prova;
		
	}
	
	public List<Prova> getProvas() {
		List<Prova> list = provaDAO.getAll(Prova.class);
		provaDAO.closeEntityManager();
		return list;
	}

	public void alterar(Prova prova){
		provaDAO.save(prova);
		provaDAO.closeEntityManager();
	}
	
	public void remover(Prova prova) {
		
		prova = provaDAO.getById(Prova.class, prova.getCodProva());
		provaDAO.remove(prova);
		provaDAO.closeEntityManager();
	}
	public Prova pesquisar(Prova prova) {

		prova = provaDAO.getById(Prova.class, prova.getCodProva());
		provaDAO.closeEntityManager();
		return prova;
	}
		

}
