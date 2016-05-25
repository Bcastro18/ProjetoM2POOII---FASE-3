package sistema.beans;




import sistema.modelos.Conteudos;
import sistema.pdf.*;
import sistema.modelos.Perguntas;
import sistema.modelos.Prova;
import sistema.service.ConteudoService;
import sistema.service.ProvaService;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;


@ManagedBean(name="provaManagedBean")
@ViewScoped

public class ProvaManagedBean 
{
	
	private Prova prova = new Prova();
	private List<Prova> provas;
	private ProvaService provaService = new ProvaService();
	private Perguntas pergunta;
	private ConteudoService contService = new ConteudoService();
	private Conteudos conteudo;
	private pdf pdfprova = new pdf();
	
	
	
	public void salvar() 
	{
		ArrayList<Perguntas> seleciona = new ArrayList<Perguntas>();
		int cont = 0;
		seleciona = conteudo.getPerguntas();
		
		for(int i = 0; i < prova.getQuantQuest(); i++){
		
			if(prova.getDificuldadeParamentro() == seleciona.get(i).getDificuldade()){
				prova.addPergunta(seleciona.get(i));
				cont++;
			} else if(i == (prova.getQuantQuest() - 1)){
				if(cont < 10 ){
					i=0;
					prova.setDificuldadeParamentro(prova.getDificuldadeParamentro()-1);
				}
			}
			
		}
		
		prova = provaService.salvar(prova);

		if (provas != null)
			provas.add(prova);
		
		for(int i = 0; i < prova.getQuantQuest(); i++){
			
		}

		prova = new Prova();
	}
	public Perguntas getPergunta() {
		return pergunta;
	}
	public void setPergunta(Perguntas pergunta) {
		this.pergunta = pergunta;
	}
	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	} 
	public List<Prova> getProvas() {
		if (provas == null)
			provas = provaService.getProvas();

		return provas;
	}
	
	public Conteudos getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(Conteudos conteudo) {
		this.conteudo = conteudo;
	}
	
	public List<Conteudos> getConteudos() {
		return contService.getConteudos();

	}

	public void remove(Prova prova) {
		provaService.remover(prova);
		provas.remove(prova);
	}
	public void onRowEdit(RowEditEvent event) {

		Prova p = ((Prova) event.getObject());
		provaService.alterar(p);
	}
	
	
}