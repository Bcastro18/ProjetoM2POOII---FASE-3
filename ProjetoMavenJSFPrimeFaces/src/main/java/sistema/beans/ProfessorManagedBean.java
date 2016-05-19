package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import sistema.service.DisciplinaService;
import sistema.service.ProfessorService;
import sistema.beans.datamodel.ProfessorDataModel;
import sistema.modelos.Disciplinas;
import sistema.modelos.Professor;

@ManagedBean(name="professorManagedBean")
@ViewScoped
public class ProfessorManagedBean {
	
	private ProfessorService professorService = new ProfessorService();
	private List<Professor> professores;
	private Professor professor = new Professor();
	private Professor professorSelecionado;
	
	
	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	public void salvar() {
		professor = professorService.salvar(professor);

		if (professores != null)
			professores.add(professor);

		professor = new Professor();

	}

	public DataModel<Professor> getProfessores() {
		if (professores == null)
			professores = professorService.getProfessores();

		return new ProfessorDataModel(professores);
	}
	
	public void remove(Professor professor) {
		if (professorService.pesquisarDisciplinassProfessor(professor).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover professor",
					"Professor possui disciplinas!"));
		} else {
			professorService.remover(professor);
			professores.remove(professor);
		}
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public List<Disciplinas> getDisciplinassProfessor() {
		if (professorSelecionado != null) {
			return professorService.pesquisarDisciplinassProfessor(professorSelecionado);
		} else
			return null;
	}

	public void onRowEdit(RowEditEvent event) {

		Professor f = ((Professor) event.getObject());
		professorService.alterar(f);
	}

}
