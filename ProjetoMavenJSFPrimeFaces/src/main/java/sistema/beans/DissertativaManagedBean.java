package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

//import sistema.beans.datamodel.DissertativaDataModel;
import sistema.modelos.Conteudos;
import sistema.modelos.Dissertativa;
import sistema.modelos.Prova;
import sistema.service.ConteudoService;
import sistema.service.DissertativaService;

@ManagedBean(name="dissertativaManagedBean")
public class DissertativaManagedBean {

	
	private DissertativaService servico = new DissertativaService();
	private ConteudoService contService = new ConteudoService();
	private Dissertativa dissertativa = new Dissertativa();
	private List<Dissertativa> dissertativas;
	private Conteudos conteudo = new Conteudos();
	private Prova prova;
	private Dissertativa dissertativaSelecionada;
	
	
	
	public void salvar() {
		
		conteudo.addPerguntas(dissertativa);
		dissertativa.addConteudo(conteudo);
		
		
		
		servico.salvar(dissertativa);
		
			if(dissertativas != null)
				dissertativas.add(dissertativa);
		
		
		dissertativa = new Dissertativa();
		conteudo = null;
		
	}
	
	
	

	public Dissertativa getDissertativaSelecionada() {
		return dissertativaSelecionada;
	}




	public void setDissertativaSelecionada(Dissertativa dissertativaSelecionada) {
		this.dissertativaSelecionada = dissertativaSelecionada;
	}




	public Prova getProva() {
		return prova;
	}



	public void setProva(Prova prova) {
		this.prova = prova;
	}



	public List<Conteudos> getConteudos() {
		return contService.getConteudos();

	}
	public Conteudos getConteudo() {
		return conteudo;
	}
	
	public void remove(Dissertativa dissertativa) {
		servico.remover(dissertativa);
		dissertativas.remove(dissertativa);
	}
	
	public void setConteudo(Conteudos conteudo) {
		this.conteudo = conteudo;
	}

	public Dissertativa getDissertativa() {
		return dissertativa;
	}

	public void setDissertativa(Dissertativa dissertativa) {
		this.dissertativa = dissertativa;
	}
	
/*	public DataModel<Dissertativa> getDisciplinasDataModel() {
		if (dissertativas == null)
			dissertativas = servico.getDissertativaes();

		return new DissertativaDataModel(dissertativas);
	}
	
*/
	public List<Dissertativa> getDissertativas(){
		if (dissertativas == null)
			dissertativas = servico.getDissertativaes();

		return dissertativas;
	}

	public void onRowEdit(RowEditEvent event) {

		Dissertativa p = ((Dissertativa) event.getObject());
		servico.alterar(p);
	}
	
}
