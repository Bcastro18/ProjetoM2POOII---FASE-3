package sistema.beans;


import sistema.modelos.Prova;
import sistema.service.DisciplinaService;
import sistema.service.ProvaService;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;


@ManagedBean
@ViewScoped

public class ProvaManagedBean 
{
	
	private Prova prova = new Prova();
	private List<Prova> provas;
	private ProvaService provaService = new ProvaService();
	private DisciplinaService discService = new DisciplinaService();
	
	public void salvar() 
	{
		//disciplina.addProva(prova);
		//prova.setDisciplina(disciplina);
		
		prova = provaService.salvar(prova);

		if (provas != null)
			provas.add(prova);

		prova = new Prova();
		//disciplina = null;
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

	public void remover(Prova prova) {
		provaService.remover(prova);
		provas.remove(prova);
	}
	public void onRowEdit(RowEditEvent event) {

		Prova p = ((Prova) event.getObject());
		provaService.alterar(p);
	}
}