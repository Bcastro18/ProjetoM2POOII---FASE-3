package sistema.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sistema.modelos.Aluno;

public class AlunoService {

	private ArrayList <Aluno> alunos = new ArrayList();
	
	public AlunoService()
	{

	}
	
	public void salvar(Aluno aluno)
	{
	    alunos.add(aluno);
	}
	

	public List <Aluno> getAlunos()
	{
		
		return alunos;
		
	}
	
	
}
