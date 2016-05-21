package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Disciplinas;
import sistema.service.DisciplinaService;


public class DisciplinaDataModel extends ListDataModel<Disciplinas> implements SelectableDataModel<Disciplinas> 
{
	private DisciplinaService servico = new DisciplinaService();
	
	public DisciplinaDataModel()
	{
		
	}

	public DisciplinaDataModel(List <Disciplinas> list)
	{
	   super(list);	
	}

	
	@Override
	public Disciplinas getRowData(String rowKey) {
		
		for(Disciplinas f: servico.getDisciplinas())
		   if(Integer.parseInt(rowKey) ==  f.getCodDisc())
			   return servico.pesquisar(f);
		
		return null;
	}

	@Override
	public Object getRowKey(Disciplinas disciplinas) {
		return disciplinas.getCodDisc();
	}
	
}