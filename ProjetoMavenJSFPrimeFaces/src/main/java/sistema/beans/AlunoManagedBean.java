package sistema.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Aluno;
import sistema.service.AlunoService;

@ManagedBean
@ViewScoped
public class AlunoManagedBean {

	private Aluno aluno = new Aluno();
	private List<Aluno> alunos;
	private AlunoService service = new AlunoService();

	
	//Edição de um aluno na tabela
	public void onRowEdit(RowEditEvent event) {

		Aluno a = ((Aluno) event.getObject());
		service.alterar(a);
	}

	
	
	public void salvar() {
		service.salvar(aluno);

		if (alunos != null)
			alunos.add(aluno);

		aluno = new Aluno();

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	//Retorna a lista de alunos para a tabela
	public List<Aluno> getAlunos() {
		if (alunos == null)
			alunos = service.getAlunos();

		return alunos;
	}

	public void remover(Aluno aluno) {
		service.remover(aluno);
		alunos.remove(aluno);

	}

}
