package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Fornecedor;
import sistema.service.FornecedorService;


public class FornecedorDataModel extends ListDataModel<Fornecedor> implements SelectableDataModel<Fornecedor> 
{
	private FornecedorService servico = new FornecedorService();
	
	public FornecedorDataModel()
	{
		
	}

	public FornecedorDataModel(List <Fornecedor> list)
	{
	   super(list);	
	}

	
	@Override
	public Fornecedor getRowData(String rowKey) {
		
		for(Fornecedor f: servico.getFornecedores())
		   if(Integer.parseInt(rowKey) ==  f.getCodigo())
			   return f;
		
		return null;
	}

	@Override
	public Object getRowKey(Fornecedor fornecedor) {
		return fornecedor.getCodigo();
	}
	
}