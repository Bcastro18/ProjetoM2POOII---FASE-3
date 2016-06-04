package sistema.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class VouF extends Perguntas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroItens;
	private String resposta;
	private List<String> alternativas = new ArrayList<String>();
	private String vouf1, vouf2, vouf3, vouf4, vouf5;

	

	public String getVouf1() {
		return vouf1;
	}

	public void setVouf1(String vouf1) {
		this.vouf1 = vouf1;
	}

	public String getVouf2() {
		return vouf2;
	}

	public void setVouf2(String vouf2) {
		this.vouf2 = vouf2;
	}

	public String getVouf3() {
		return vouf3;
	}

	public void setVouf3(String vouf3) {
		this.vouf3 = vouf3;
	}

	public String getVouf4() {
		return vouf4;
	}

	public void setVouf4(String vouf4) {
		this.vouf4 = vouf4;
	}

	public String getVouf5() {
		return vouf5;
	}

	public void setVouf5(String vouf5) {
		this.vouf5 = vouf5;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public int getNumeroItens() {
		return numeroItens;
	}

	public void setNumeroItens(int numeroItens) {
		this.numeroItens = numeroItens;
	}
	
	public List<String> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}
	
	
	public void addAlternativa(){
		alternativas.add(vouf1);
		alternativas.add(vouf2);
		alternativas.add(vouf3);
		alternativas.add(vouf4);
		alternativas.add(vouf5);

	}

}
