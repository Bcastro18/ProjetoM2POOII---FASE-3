package sistema.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class MultiplaEscolha extends Perguntas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroItens;
	private String resposta;
	private List<String> alternativas = new ArrayList<String>();
	private String alterna1, alterna2, alterna3, alterna4, alterna5;
	
	
	
	public String getAlterna1() {
		return alterna1;
	}
	public void setAlterna1(String alterna1) {
		this.alterna1 = alterna1;
	}
	public String getAlterna2() {
		return alterna2;
	}
	public void setAlterna2(String alterna2) {
		this.alterna2 = alterna2;
	}
	public String getAlterna3() {
		return alterna3;
	}
	public void setAlterna3(String alterna3) {
		this.alterna3 = alterna3;
	}
	public String getAlterna4() {
		return alterna4;
	}
	public void setAlterna4(String alterna4) {
		this.alterna4 = alterna4;
	}
	public String getAlterna5() {
		return alterna5;
	}
	public void setAlterna5(String alterna5) {
		this.alterna5 = alterna5;
	}
	public int getNumeroItens() {
		return numeroItens;
	}
	public void setNumeroItens(int numeroItens) {
		this.numeroItens = numeroItens;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public List<String> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}
	
	public void addAlternativa(){
		alternativas.add(alterna1);
		alternativas.add(alterna2);
		alternativas.add(alterna3);
		alternativas.add(alterna4);
		alternativas.add(alterna5);

	}
	
	
	
	
	
}
