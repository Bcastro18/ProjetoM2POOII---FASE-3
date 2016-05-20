package sistema.service;

import java.util.List;

import sistema.dao.ConteudoDAO;
import sistema.modelos.Conteudos;
import sistema.modelos.Disciplinas;
//import sistema.modelos.Perguntas;

public class ConteudoService {
	
	
	ConteudoDAO conteudoDAO = new ConteudoDAO();
	
	public Conteudos salvar(Conteudos conteudo){
		
		conteudo = conteudoDAO.save(conteudo);
		conteudoDAO.closeEntityManager();
		return conteudo;
		
	}
	
	public void alterar(Conteudos conteudo){
		conteudoDAO.save(conteudo);
		conteudoDAO.closeEntityManager();
	}
	
	public List<Conteudos> getConteudos() {
		List<Conteudos> list = conteudoDAO.getAll(Conteudos.class);
		conteudoDAO.closeEntityManager();
		return list;
	}
	
	public void remover(Conteudos conteudo) {
		
		conteudo = conteudoDAO.getById(Conteudos.class, conteudo.getCodConteudo());
		conteudoDAO.remove(conteudo);
		conteudoDAO.closeEntityManager();
	}
	

	/*public List<Perguntas> pesquisarPerguntasConteudos(Conteudos conteudo) {

		List<Perguntas> perguntas;
		conteudo = conteudoDAO.getById(Conteudos.class, conteudo.getCodConteudo());
		perguntas = conteudo.getPerguntas();
		return perguntas;
	}
		*/
		
	

}
