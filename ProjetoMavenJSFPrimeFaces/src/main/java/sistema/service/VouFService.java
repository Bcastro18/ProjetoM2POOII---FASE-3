package sistema.service;

import java.util.List;

import sistema.dao.VouFDAO;
import sistema.modelos.VouF;

public class VouFService {
	
	
	
	VouFDAO voufDAO = new VouFDAO();
	
	public VouF salvar(VouF vouf){
		
		vouf = voufDAO.save(vouf);
		voufDAO.closeEntityManager();
		return vouf;
		
	}
	public List <VouF> getVouFes()
	{
		List <VouF> list = voufDAO.getAll(VouF.class);
		voufDAO.closeEntityManager();
		return list;
	}
	
	public void alterar(VouF vouf) {
		voufDAO.save(vouf);
		voufDAO.closeEntityManager();
	}
	
	public void remover(VouF vouf) {
		
		vouf = voufDAO.getById(VouF.class, vouf.getCodPergunta());
		voufDAO.remove(vouf);
		voufDAO.closeEntityManager();
	}
	public VouF pesquisar(VouF vouf) {

		vouf = voufDAO.getById(VouF.class, vouf.getCodPergunta());
		voufDAO.closeEntityManager();
		return vouf;
	}
	

}
