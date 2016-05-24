package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import sistema.modelos.VouF;
import sistema.service.VouFService;

public class VouFDataModel extends ListDataModel<VouF> implements SelectableDataModel<VouF> {

private VouFService servico = new VouFService();
	
	public VouFDataModel()
	{
		
	}

	public VouFDataModel(List <VouF> list)
	{
	   super(list);	
	}

	
	@Override
	public VouF getRowData(String rowKey) {
		
		for(VouF f: servico.getVouFes())
		   if(Integer.parseInt(rowKey) ==  f.getCodPergunta())
			   return servico.pesquisar(f);
		
		return null;
	}

	@Override
	public Object getRowKey(VouF vouf) {
		return vouf.getCodPergunta();
	}
}
