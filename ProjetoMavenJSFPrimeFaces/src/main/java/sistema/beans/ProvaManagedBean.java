package sistema.beans;




import sistema.modelos.Conteudos;
import sistema.modelos.MultiplaEscolha;
import sistema.modelos.Perguntas;
import sistema.modelos.Prova;
import sistema.modelos.VouF;
import sistema.service.ConteudoService;
import sistema.service.PerguntaService;
import sistema.service.ProvaService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ReorderEvent;
import org.primefaces.event.RowEditEvent;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


@ManagedBean(name="provaManagedBean")
@ViewScoped

public class ProvaManagedBean 
{
	
	private Prova prova = new Prova();
	private List<Prova> provas;
	private ProvaService provaService = new ProvaService();
	private Perguntas pergunta;
	private List<Perguntas> perguntas;
	private ConteudoService contService = new ConteudoService();
	private PerguntaService pergService = new PerguntaService();
	private Conteudos conteudo;
	private List<Conteudos> conteudos;
	private List<Conteudos> conteudoSelecionados;

	
	
	
	public void salvar() 
	{
		List<Perguntas> seleciona = pergService.getPerguntas();
		int cont = 0;
		
		for(int i = 0; i < seleciona.size(); i++){
		
			if(seleciona.get(i) .getDificuldade() <= seleciona.get(i).getDificuldade() || cont < prova.getQuantQuest()){
				prova.addPergunta(seleciona.get(i));
				cont++;
			}			
		}
		if(prova.getPerguntas().size() < prova.getQuantQuest() && seleciona.size() >= prova.getQuantQuest())
		{
			int falta = 0;
			
			falta = prova.getQuantQuest() - prova.getPerguntas().size();
			
			for(int i = 0; i < falta; i++)
			{
				if(seleciona.get(i).getDificuldade() > prova.getDificuldadeParamentro())
				{
					prova.addPergunta(seleciona.get(i));
				}
			}
		}
		
		for(int i = 0; i < conteudoSelecionados.size(); i++)			
 			prova.addConteudo(conteudoSelecionados.get(i));
  		
		
		prova = provaService.salvar(prova);

		if (provas != null)
			provas.add(prova);
		

		prova = new Prova();
	}
	@SuppressWarnings("deprecation")
	public void gera() {
		
        Document document = new Document();
        String strinConteudos = "";
       	        
        try {
           
        	 PdfWriter.getInstance(document, 
        		        new FileOutputStream("C:\\Users\\Bruno\\Documents\\"+ prova.getCodProva()+"-"+prova.getNome()+".pdf"));
        	 document.open();
           
            for(int i = 0; i < prova.getConteudos().size(); i++)
            {
         	   if(prova.getConteudos().size() == 1)
         	   {
         		  strinConteudos = strinConteudos + prova.getConteudos().get(i).getNome();
        	   }
         	   else
         	   {
         		  strinConteudos = strinConteudos + prova.getConteudos().get(i).getNome() + ", ";
         	   }
            }
            document.add(new Paragraph("Faculdade: " + prova.getFaculdade()));
            document.add(new Paragraph("Curso: " + prova.getCurso()));
            document.add(new Paragraph("Turma: " + prova.getTurma()));
            document.add(new Paragraph("Data da prova: " + prova.getData_App().getDay()
         		   +"/"+prova.getData_App().getMonth()+"/"+prova.getData_App().getYear()));
            //document.add(new Paragraph("Dificuldade: " + prova.getDificuldadeParamentro()));
            document.add(new Paragraph("Conteudo(s): " + strinConteudos));
                       
            for(int i = 0; i < prova.getPerguntas().size(); i++)
            {
         	   		document.add(new Paragraph(""+(i + 1)+") " + prova.getPerguntas().get(i).getEnunciado()));
         	   		document.add(new Paragraph(""+ "Tempo Estimado: "+  prova.getPerguntas().get(i).getTempo_estimado() +", Dificulade: " + 
         	   				prova.getPerguntas().get(i).getDificuldade()));
         	   		document.add( Chunk.NEWLINE );
         	   		
         	   if(prova.getPerguntas().get(i) instanceof MultiplaEscolha)
         	   {
         	   	MultiplaEscolha me = (MultiplaEscolha)prova.getPerguntas().get(i);
     
         		int cont = 1;
         	   	for(int j = 0; j < 5; j++)
         		   {
         			   document.add(new Paragraph(""+ cont + ") "+ me.getAlternativas().get(j)));
         			   cont++;
         			   document.add( Chunk.NEWLINE );
         		   }
         		  
         	   }
         	   else if(prova.getPerguntas().get(i) instanceof VouF)
         	   {
         		  VouF vf = (VouF)prova.getPerguntas().get(i);
           			int cont = 1;
           			for(int j = 0; j < 5; j++)
           				{
           					document.add(new Paragraph(""+ cont + ") "+"(  )" + vf.getAlternativas().get(j)));
           					cont++;
           					document.add( Chunk.NEWLINE );
           				}
         	   }
         	   
         	   		
         		   document.add(new Paragraph("Resposta:"));
         		   document.add(Chunk.NEWLINE);
        		   document.add(Chunk.NEWLINE);
         		   document.add(Chunk.NEWLINE);
            }
            
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
            }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
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
	
	public List<Perguntas> getPerguntas()
	{
		if(perguntas == null)
			return pergService.getPerguntas();
		return perguntas;
	}
	
	public List<Conteudos> getConteudos() {
		if(conteudos == null)
			conteudos = contService.getConteudos();
		return conteudos;

	}

	public List<Conteudos> getConteudoSelecionados() {
		return conteudoSelecionados;
	}
	
	public void setConteudoSelecionados(List<Conteudos> conteudoSelecionados) {
		this.conteudoSelecionados = conteudoSelecionados;
	}
	
	public void setPerguntas(List<Perguntas> perguntas) {
		this.perguntas = perguntas;
	}
	
	public void remove(Prova prova) {
		provaService.remover(prova);
		provas.remove(prova);
	}
	public void onRowEdit(RowEditEvent event) {

		Prova p = ((Prova) event.getObject());
		provaService.alterar(p);
	}
	
	public void onRowReorder(ReorderEvent event) {
        FacesMessage msg = new FacesMessage();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
}