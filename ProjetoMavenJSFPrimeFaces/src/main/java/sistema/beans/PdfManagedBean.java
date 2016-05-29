package sistema.beans;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import sistema.modelos.MultiplaEscolha;
import sistema.modelos.Prova;
import sistema.modelos.VouF;
import sistema.service.ProvaService;

@ManagedBean(value = "pdfManagedBean")
@ViewScoped
public class PdfManagedBean {
	
	
		 
		 	private Prova prova;
		 	private List<Prova> provas;
		 	private ProvaService provaService = new ProvaService(); 
		 	
		 	public Prova getProva() {
		 		return prova;
		 	}
		 	public void setProva(Prova prova) {
		 		this.prova = prova;
		 	}
		 	public void setProvas(List<Prova> provas) {
		 		this.provas = provas;
		 	}
		 	public List<Prova> getProvas() {
		 		if (provas == null)
		 			provas = provaService.getProvas();
		 		return provas;
		 	}
		 
			public void gera() {
		        Document document = new Document();
		        String strinConteudos = "";
		       	        
		        try {
		           
		            PdfWriter.getInstance(document, new FileOutputStream("C:\\prova"+ prova.getCodProva()+ "--" + prova.getNome()+".pdf"));
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
		            document.add(new Paragraph("Dificuldade: " + prova.getDificuldadeParamentro()));
		            document.add(new Paragraph("Conteudo(s): " + strinConteudos));
		           
		            
		            document.add(Chunk.NEWLINE);
		            
		            for(int i = 0; i < prova.getPerguntas().size(); i++)
		            {
		         	   		document.add(new Paragraph(""+(i + 1)+") " + prova.getPerguntas().get(i).getEnunciado()));
		         	   		document.add(new Paragraph(""+ "Tempo Estimado: "+  prova.getPerguntas().get(i).getTempo_estimado() +", Dificulade: " + 
		         	   				prova.getPerguntas().get(i).getDificuldade()));
		         	   		document.add( Chunk.NEWLINE );
		         	   
		         	   		
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
 }

