package sistema.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class MultiplaEscolha extends Perguntas {

	private int numeroItens;
	private String resposta;
	private List<String> alternativas = new ArrayList<String>();
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
	
	
	
	
	
}
