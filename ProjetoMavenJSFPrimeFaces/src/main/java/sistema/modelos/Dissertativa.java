package sistema.modelos;

import javax.persistence.Entity;

@Entity
public class Dissertativa extends Perguntas 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resposta;

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
}
