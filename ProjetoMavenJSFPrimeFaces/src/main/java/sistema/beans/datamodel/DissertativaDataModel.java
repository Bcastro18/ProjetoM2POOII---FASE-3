package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import sistema.modelos.Dissertativa;
import sistema.modelos.VouF;
import sistema.service.DissertativaService;

public class DissertativaDataModel extends ListDataModel<Dissertativa> implements SelectableDataModel<Dissertativa> {
	

private DissertativaService servico = new DissertativaService();
	
	public DissertativaDataModel()
	{
		
	}

	public DissertativaDataModel(List <Dissertativa> list)
	{
	   super(list);	
	}

	
	@Override
	public Dissertativa getRowData(String rowKey) {
		
		for(Dissertativa f: servico.getDissertativaes())
		   if(Integer.parseInt(rowKey) ==  f.getCodPergunta())
			   return servico.pesquisar(f);
		
		return null;
	}

	@Override
	public Object getRowKey(Dissertativa dissertativa) {
		return dissertativa.getCodPergunta();
	}

}
