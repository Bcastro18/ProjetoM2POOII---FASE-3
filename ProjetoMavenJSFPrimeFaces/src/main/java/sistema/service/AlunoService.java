package sistema.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.dao.AlunoDAO;
import sistema.modelos.Aluno;


public class AlunoService {

 	AlunoDAO alunoDAO = new AlunoDAO();
 	
	public Aluno salvar(Aluno aluno)
	{
		aluno = alunoDAO.save(aluno);
		alunoDAO.closeEntityManager();
		return aluno;
		
	}
	
	public List <Aluno> getAlunos()
	{
		List <Aluno> list = alunoDAO.getAll(Aluno.class);
		alunoDAO.closeEntityManager();
		return list;
	}

	public void alterar(Aluno aluno) {
		alunoDAO.save(aluno);
		alunoDAO.closeEntityManager();
	}

	
	public void remover(Aluno aluno) {
		
		aluno = alunoDAO.getById(Aluno.class, aluno.getMatricula());
		alunoDAO.remove(aluno);
		alunoDAO.closeEntityManager();
	}
	
}
