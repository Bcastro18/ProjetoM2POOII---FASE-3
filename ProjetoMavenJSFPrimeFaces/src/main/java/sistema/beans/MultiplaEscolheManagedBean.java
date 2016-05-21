package sistema.beans;

import sistema.service.ServicePerguntasGeral;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.MultiplaEscolha;

public class MultiplaEscolheManagedBean {
	
	private MultiplaEscolha alternativa = new MultiplaEscolha();
	private List<MultiplaEscolha> alternativas = new ArrayList<MultiplaEscolha>();
	private ServicePerguntasGeral service = new ServicePerguntasGeral();
	
	public void salvar() {
		service.salvar(alternativa);

		if (alternativas != null)
			alternativas.add(alternativa);

		alternativa = new MultiplaEscolha();
	}

	public MultiplaEscolha getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(MultiplaEscolha alternativa) {
		this.alternativa = alternativa;
	} 
	public List<MultiplaEscolha> getAlternativas() {
		if (alternativas == null)
			alternativas = service.getAs();

		return alternativas;
	}

	public void remover(MultiplaEscolha alternativa) {
		service.remover(alternativa);
		alternativas.remove(alternativa);
	}

}
