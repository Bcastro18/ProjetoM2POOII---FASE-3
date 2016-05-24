package sistema.service;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import sistema.modelos.MultiplaEscolha;

public class MultiplaEscolhaDataModel extends ListDataModel<MultiplaEscolha> implements SelectableDataModel<MultiplaEscolha> {

private MultiplaEscolhaService servico = new MultiplaEscolhaService();
	
	public MultiplaEscolhaDataModel()
	{
		
	}

	public MultiplaEscolhaDataModel(List <MultiplaEscolha> list)
	{
	   super(list);	
	}

	
	@Override
	public MultiplaEscolha getRowData(String rowKey) {
		
		for(MultiplaEscolha f: servico.getMultiplaEscolhaes())
		   if(Integer.parseInt(rowKey) ==  f.getCodPergunta())
			   return servico.pesquisar(f);
		
		return null;
	}

	@Override
	public Object getRowKey(MultiplaEscolha me) {
		return me.getCodPergunta();
	}
}
