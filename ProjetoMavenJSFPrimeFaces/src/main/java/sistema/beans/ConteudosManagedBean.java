package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.ConteudoDataModel;
import sistema.beans.datamodel.DisciplinaDataModel;
import sistema.modelos.Conteudos;

import sistema.modelos.Disciplinas;
import sistema.modelos.Perguntas;
//import sistema.modelos.Perguntas;
import sistema.service.ConteudoService;

import sistema.service.DisciplinaService;
import sistema.service.PerguntaService;

@ManagedBean(name = "conteudoManagedBean")
@ViewScoped
public class ConteudosManagedBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Conteudos conteudo = new Conteudos();
	private List<Conteudos> conteudos;
	private List<Perguntas> perguntas;
	private List<Perguntas> perguntasSelec;
	private Disciplinas disciplina;
	private ConteudoService contService = new ConteudoService();
	private PerguntaService pergService = new PerguntaService();
	private DisciplinaService discService = new DisciplinaService();
	
	
	public void salvar() 
	{
		disciplina.addConteudos(conteudo);;
		conteudo.setDisciplina(disciplina);

		conteudo = contService.salvar(conteudo);

		if (conteudos != null)
			conteudos.add(conteudo);

		conteudo = new Conteudos();
		disciplina = null;

	}

	public List<Disciplinas> getDisciplinas() 
	{
		return discService.getDisciplinas();

	}

	public Disciplinas getDisciplina() 
	{
		return disciplina;
	}

	public void remove(Conteudos conteudo) 
	{
		contService.remover(conteudo);
		conteudos.remove(conteudo);
	}

	public void setDisciplina(Disciplinas disciplina) 
	{
		this.disciplina = disciplina;
	}

	public Conteudos getConteudo() 
	{
		return conteudo;
	}

	public void setConteudo(Conteudos conteudo) 
	{
		this.conteudo = conteudo;
	}
	
	public void setPerguntas(List<Perguntas> perguntas) 
	{
		this.perguntas = perguntas;
	}

	public List<Perguntas> getPerguntasSelec() {
		return perguntasSelec;
	}

	public void setPerguntasSelec(List<Perguntas> perguntasSelec) {
		this.perguntasSelec = perguntasSelec;
	}

	public List<Conteudos> getConteudos() {
		if (conteudos == null)
			conteudos = contService.getConteudos();

		return conteudos;
	}
	
	public List<Perguntas> getPerguntas() {
		if (perguntas == null)	
			return pergService.getPerguntas();
		return perguntas;
	}

	public void onRowEdit(RowEditEvent event) {

		Conteudos c = ((Conteudos) event.getObject());
		contService.alterar(c);
	}

}
