package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Conteudos;
import sistema.service.ConteudoService;


public class ConteudoDataModel extends ListDataModel<Conteudos> implements SelectableDataModel<Conteudos> 
{
	private ConteudoService servico = new ConteudoService();
	
	public ConteudoDataModel()
	{
		
	}

	public ConteudoDataModel(List <Conteudos> list)
	{
	   super(list);	
	}

	
	@Override
	public Conteudos getRowData(String rowKey) {
		
		for(Conteudos f: servico.getConteudos())
		   if(Integer.parseInt(rowKey) ==  f.getCodConteudo())
			   return f;
		
		return null;
	}

	@Override
	public Object getRowKey(Conteudos Conteudo) {
		return Conteudo.getCodConteudo();
	}
	
}