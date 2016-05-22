package sistema.service;

import java.util.List;

import sistema.dao.DisciplinaDAO;
import sistema.modelos.Conteudos;
import sistema.modelos.Disciplinas;
import sistema.modelos.Professor;

public class DisciplinaService {
	

	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	
	public Disciplinas salvar(Disciplinas disciplina){
		
		disciplina = disciplinaDAO.save(disciplina);
		disciplinaDAO.closeEntityManager();
		return disciplina;
		
	}
	public List<Disciplinas> getDisciplinas() {
		List<Disciplinas> list = disciplinaDAO.getAll(Disciplinas.class);
		disciplinaDAO.closeEntityManager();
		return list;
	}
	
	public void alterar(Disciplinas disciplina){
		disciplinaDAO.save(disciplina);
		disciplinaDAO.closeEntityManager();
	}
	
	public List<Conteudos> pesquisarConteudosDisciplinas(Disciplinas disciplina) {

		List<Conteudos> conteudos;

		disciplina = disciplinaDAO.getById(Disciplinas.class, disciplina.getCodDisc() );
		conteudos = disciplina.getConteudos();

		return conteudos;
	}
	
	public void remover(Disciplinas disciplina) {
		
		disciplina = disciplinaDAO.getById(Disciplinas.class, disciplina.getCodDisc());
		disciplinaDAO.remove(disciplina);
		disciplinaDAO.closeEntityManager();
	}
	
	public Disciplinas pesquisar(Disciplinas disciplina) {

		disciplina = disciplinaDAO.getById(Disciplinas.class, disciplina.getCodDisc());
		disciplinaDAO.closeEntityManager();
		return disciplina;
	}
	

}
