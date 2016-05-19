package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;

import sistema.dao.ProfessorDAO;
import sistema.modelos.Disciplinas;
import sistema.modelos.Professor;

public class ProfessorService {
			
		ProfessorDAO professorDAO = new ProfessorDAO();
		
		public Professor salvar(Professor professor){
			
			professor = professorDAO.save(professor);
			professorDAO.closeEntityManager();
			return professor;
			
		}
		public List <Professor> getProfessores()
		{
			List <Professor> list = professorDAO.getAll(Professor.class);
			professorDAO.closeEntityManager();
			return list;
		}
		
		public void alterar(Professor professor) {
			professorDAO.save(professor);
			professorDAO.closeEntityManager();
		}
		
		public void remover(Professor professor) {
			
			professor = professorDAO.getById(Professor.class, professor.getMatricula());
			professorDAO.remove(professor);
			professorDAO.closeEntityManager();
		}
		
		public List<Disciplinas> pesquisarDisciplinassProfessor(Professor professor) {

			List<Disciplinas> disciplinas;

			professor = professorDAO.getById(Professor.class, professor.getMatricula());
			disciplinas = professor.getDisciplinas();

			return disciplinas;
		}
			
			
		

	


}
