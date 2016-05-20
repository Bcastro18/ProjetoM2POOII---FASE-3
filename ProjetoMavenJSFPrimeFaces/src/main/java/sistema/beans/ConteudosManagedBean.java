package sistema.beans;

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
//import sistema.modelos.Perguntas;
import sistema.service.ConteudoService;

import sistema.service.DisciplinaService;

@ManagedBean(name = "conteudosManagedBean")
@ViewScoped
public class ConteudosManagedBean {
	
	//private Perguntas pergunta = new Perguntas();
	private Conteudos conteudoSelecionado;
	private Conteudos conteudo = new Conteudos();
	private Disciplinas disciplina;
	private ConteudoService contService = new ConteudoService();
	private DisciplinaService discService = new DisciplinaService();
	private List<Conteudos> conteudos;
	
	
	public void salvar() {
		disciplina.addConteudos(conteudo);
		conteudo.setDisciplina(disciplina);

		conteudo = contService.salvar(conteudo);

		if (conteudos != null)
			conteudos.add(conteudo);

		conteudo = new Conteudos();
		disciplina = null;

	}

	public List<Disciplinas> getDisciplinas() {
		return discService.getDisciplinas();

	}

	public Disciplinas getDisciplina() {
		return disciplina;
	}
	

	public Conteudos getConteudoSelecionado() {
		return conteudoSelecionado;
	}

	public void setConteudoSelecionado(Conteudos conteudoSelecionado) {
		this.conteudoSelecionado = conteudoSelecionado;
	}

	public void remove(Conteudos conteudo) {
		contService.remover(conteudo);
		conteudos.remove(conteudo);
	}
	
	/*public void removePesquisa(Conteudos conteudo) {
		if (contService.pesquisarPerguntasConteudos(conteudo).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover conteudo",
					"conteudo possui pergunta!"));
		} else {
			contService.remover(conteudo);
			conteudos.remove(conteudo);
		}
	}
*/
	public void setDisciplinas(Disciplinas disciplinas) {
		this.disciplina = disciplinas;
	}

	public Conteudos getConteudo() {
		return conteudo;
	}

	public void setConteudos(Conteudos conteudo) {
		this.conteudo = conteudo;
	}

	public List<Conteudos> getConteudos() {
		if (conteudos == null)
			conteudos = contService.getConteudos();

		return conteudos;
	}

	public void onRowEdit(RowEditEvent event) {

		Conteudos p = ((Conteudos) event.getObject());
		contService.alterar(p);
	}
	
	public DataModel<Conteudos> getConteudosDataModel() {
		if (conteudos == null)
			conteudos = contService.getConteudos();

		return new ConteudoDataModel(conteudos);
	}
	
	/*public List<Perguntas> getPerguntasConteudos() {
		if (conteudoSelecionado != null) {
			return contService.pesquisarPerguntasConteudos(conteudoSelecionado);
		} else
			return null;
	}
	*/

}
