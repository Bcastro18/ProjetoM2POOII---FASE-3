package sistema.beans;

import sistema.service.ConteudoService;
import sistema.service.ServicePerguntasGeral;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.DisciplinaDataModel;
import sistema.beans.datamodel.VouFDataModel;
import sistema.modelos.Conteudos;
import sistema.modelos.Disciplinas;
import sistema.modelos.Professor;
import sistema.modelos.VouF;

public class VouFManagedBean {

	private ServicePerguntasGeral servico = new ServicePerguntasGeral();
	private ConteudoService contService = new ConteudoService();
	private VouF vouf = new VouF();
	private List<VouF> voufs;
	private Conteudos conteudo;
	
	
	
	public void salvar() {
		conteudo.addPerguntas(vouf);
		vouf.setConteudo(conteudo);
		
		servico.salvar(vouf);
		
			if(voufs != null)
				voufs.add(vouf);
		
		
		vouf = new VouF();
		conteudo = null;
	}
	
	public List<Conteudos> getConteudos() {
		return contService.getConteudos();

	}
	public Conteudos getConteudo() {
		return conteudo;
	}
	
	public void remove(VouF vouf) {
		servico.remover(vouf);
		voufs.remove(vouf);
	}
	
	public void setConteudo(Conteudos conteudo) {
		this.conteudo = conteudo;
	}

	public VouF getVouF() {
		return vouf;
	}

	public void setVouF(VouF vouf) {
		this.vouf = vouf;
	}
	
	public DataModel<VouF> getDisciplinasDataModel() {
		if (voufs == null)
			voufs = servico.getAs();

		return new VouFDataModel(voufs);
	}
	

	public List<VouF> getVouFs(){
		if (voufs == null)
			voufs = servico.getAs();

		return voufs;
	}

	public void onRowEdit(RowEditEvent event) {

		VouF p = ((VouF) event.getObject());
		servico.alterar(p);
	}

	
	
}
