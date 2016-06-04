package sistema.beans;

import sistema.service.ConteudoService;
import sistema.service.MultiplaEscolhaService;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Conteudos;
import sistema.modelos.MultiplaEscolha;
import sistema.modelos.Prova;
import sistema.modelos.VouF;

@ManagedBean(name="multiplaescManagedBean")
public class MultiplaEscolheManagedBean {
	
	private MultiplaEscolha alternativa = new MultiplaEscolha();
	private List<MultiplaEscolha> questoes = new ArrayList<MultiplaEscolha>();
	private MultiplaEscolhaService service = new MultiplaEscolhaService();
	private ConteudoService contService = new ConteudoService();
	private Conteudos conteudo = new Conteudos();
	private Prova prova;
	private MultiplaEscolha multiplaescSelecionada;
	private List<String> alternativas = new ArrayList<String>();
	
	public void salvar() {

		alternativa.addAlternativa();
		alternativa.addConteudo(conteudo);
		conteudo.addPerguntas(alternativa);
		
		
		service.salvar(alternativa);

		if (questoes != null)
			questoes.add(alternativa);

		alternativa = new MultiplaEscolha();
		
	}
	
	public MultiplaEscolha getMultiplaescSelecionada() {
		return multiplaescSelecionada;
	}



	public void setMultiplaescSelecionada(MultiplaEscolha multiplaescSelecionada) {
		this.multiplaescSelecionada = multiplaescSelecionada;
	}



	public List<Conteudos> getConteudos() {
		return contService.getConteudos();

	}
	
	public Prova getProva() {
		return prova;
	}
	public void setProva(Prova prova) {
		this.prova = prova;
	}
	public MultiplaEscolha getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(MultiplaEscolha alternativa) {
		this.alternativa = alternativa;
	} 
	
	public Conteudos getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudos conteudo) {
		this.conteudo = conteudo;
	}

	public List<MultiplaEscolha> getAlternativas() {
		if (questoes == null)
			questoes = service.getMultiplaEscolhaes();

		return questoes;
	}

	public void remove(MultiplaEscolha alternativa) {
		service.remover(alternativa);
		questoes.remove(alternativa);
	}
	
	public void onRowEdit(RowEditEvent event) {

		MultiplaEscolha p = ((MultiplaEscolha) event.getObject());
		service.alterar(p);
	}

}
