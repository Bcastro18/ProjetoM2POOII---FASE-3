package sistema.beans;

import sistema.service.ConteudoService;
import sistema.service.VouFService;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;


import sistema.beans.datamodel.VouFDataModel;
import sistema.modelos.Conteudos;
import sistema.modelos.Prova;
import sistema.modelos.VouF;
@ManagedBean(name="voufManagedBean")
public class VouFManagedBean {

	private VouF vouf = new VouF();
	private VouFService servico = new VouFService();
	private ConteudoService contService = new ConteudoService();
	private List<VouF> voufs;
	private Conteudos conteudo = new Conteudos();
	private Prova prova;
	private VouF voufSelecionada;
	
	
	public void salvar() {
		conteudo.addPerguntas(vouf);
		vouf.addConteudo(conteudo);
		
		
		servico.salvar(vouf);
		
			if(voufs != null)
				voufs.add(vouf);
		
		
		vouf = new VouF();
		conteudo = null;
		
	}
		
	
	public VouF getVoufSelecionada() {
		return voufSelecionada;
	}



	public void setVoufSelecionada(VouF voufSelecionada) {
		this.voufSelecionada = voufSelecionada;
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
			voufs = servico.getVouFes();

		return new VouFDataModel(voufs);
	}
	

	public List<VouF> getVouFs(){
		if (voufs == null)
			voufs = servico.getVouFes();

		return voufs;
	}

	public void onRowEdit(RowEditEvent event) {

		VouF p = ((VouF) event.getObject());
		servico.alterar(p);
	}

	
	
}
