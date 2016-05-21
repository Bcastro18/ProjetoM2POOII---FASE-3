package sistema.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.DisciplinaDataModel;
import sistema.modelos.*;
import sistema.service.DisciplinaService;
import sistema.service.ProfessorService;

@ManagedBean(name = "disciplinaManagedBean")
@ViewScoped
public class DisciplinasManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor;
	private Disciplinas disciplina = new Disciplinas();
	private Disciplinas disciplinaSelecionada;
	private ProfessorService profService = new ProfessorService();
	private DisciplinaService discService = new DisciplinaService();
	private List<Disciplinas> disciplinas;
	
	
	
	public void salvar(){
		
		professor.addDisciplinas(disciplina);
		disciplina.setProfessor(professor);
		
		disciplina = discService.salvar(disciplina);
		
		if(disciplinas != null)
			disciplinas.add(disciplina);
		
		disciplina = new Disciplinas();
		professor = null;

	}
	public List<Professor> getProfessores() {
		return profService.getProfessores();

	}
	public Professor getProfessor() {
		return professor;
	}
	
	public Disciplinas getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}
	public void setDisciplinaSelecionada(Disciplinas disciplinaSelecionada) {
		this.disciplinaSelecionada = discService.pesquisar(disciplinaSelecionada);
	}
	public void remove(Disciplinas disciplina) {
		discService.remover(disciplina);
		disciplinas.remove(disciplina);
	}
	
	public void removePesquisa(Disciplinas disciplina) {
		if (discService.pesquisarConteudosDisciplinas(disciplina).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover disciplina",
					"disciplina possui conteudos!"));
		} else {
			discService.remover(disciplina);
			disciplinas.remove(disciplina);
		}
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplinas getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplinas disciplina) {
		this.disciplina = disciplina;
	}
	
	public DataModel<Disciplinas> getDisciplinasDataModel() {
		if (disciplinas == null)
			disciplinas = discService.getDisciplinas();

		return new DisciplinaDataModel(disciplinas);
	}
	
	public List<Conteudos> getConteudosDisciplinas() {
		if (disciplinaSelecionada != null) {
			return discService.pesquisarConteudosDisciplinas(disciplinaSelecionada);
		} else
			return null;
	}

	public List<Disciplinas> getDisciplinas(){
		if (disciplinas == null)
			disciplinas = discService.getDisciplinas();

		return disciplinas;
	}

	public void onRowEdit(RowEditEvent event) {

		Disciplinas p = ((Disciplinas) event.getObject());
		discService.alterar(p);
	}

}

