package sistema.modelos;

import javax.persistence.Entity;

@Entity
public class VouF extends Perguntas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroItens;
	private String resposta;

	

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
	

}
