package sistema.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class pdf {

	public static void main(String[] args) {
	        // criação do objeto documento
	       Document document = new Document();
	       try {
	           
	           PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Bruno/Documents"));
	           document.open();
	           
	           // adicionando um parágrafo ao documento
	           document.add(new Paragraph("Exemplo Geração de Arquivo PDF via iText - Java"));
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