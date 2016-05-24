package sistema.service;

import java.util.List;

import sistema.dao.DissertativaDAO;
import sistema.dao.MultiplaEscolhaDAO;
import sistema.dao.PerguntasGeralDAO;
import sistema.dao.VouFDAO;
import sistema.modelos.*;

public class PerguntaService {

	private PerguntasGeralDAO perguntaDAO = new PerguntasGeralDAO();
	private DissertativaDAO dissertativaDAO = new DissertativaDAO();
	private MultiplaEscolhaDAO multiplaEscolhaDAO = new MultiplaEscolhaDAO();
	private VouFDAO vfDAO = new VouFDAO();

	public Perguntas salvarDissertativa(Dissertativa dissertativa) 
	{
		dissertativa = dissertativaDAO.save(dissertativa);
		dissertativaDAO.closeEntityManager();
		return dissertativa;

	}
	public Perguntas salvarMultiplaEscolha(MultiplaEscolha multiplaEscolha) 
	{
		multiplaEscolha = multiplaEscolhaDAO.save(multiplaEscolha);
		multiplaEscolhaDAO.closeEntityManager();
		return multiplaEscolha;

	}
	public Perguntas salvarVerdadeiroFalso(VouF vf) 
	{
		vf = vfDAO.save(vf);
		vfDAO.closeEntityManager();
		return vf;

	}
	public List<Perguntas> getPerguntas() {
		List<Perguntas> list = perguntaDAO.getAll(Perguntas.class);
		perguntaDAO.closeEntityManager();
		return list;
	}

	public void alterar(Perguntas pergunta) {
		perguntaDAO.save(pergunta);
		perguntaDAO.closeEntityManager();
	}

	public void remover(Perguntas pergunta) {

		pergunta = perguntaDAO.getById(Perguntas.class,
				pergunta.getCodPergunta());
		perguntaDAO.remove(pergunta);
		perguntaDAO.closeEntityManager();
	}
	public Perguntas pesquisar(Perguntas pergunta) 
	{
		pergunta = perguntaDAO.getById(Perguntas.class, pergunta.getCodPergunta());
		perguntaDAO.closeEntityManager();
		return pergunta;
	}
	
}