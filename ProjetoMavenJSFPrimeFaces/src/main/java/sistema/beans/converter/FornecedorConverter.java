package sistema.beans.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Fornecedor;
import sistema.service.FornecedorService;



@FacesConverter("converterFornecedor")
public class FornecedorConverter implements Converter {

	private FornecedorService servico = new FornecedorService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Fornecedor f : servico.getFornecedores())
				 if(f.getNome().equals(value))
				  	return f;
					
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object fornecedor) {
		if (fornecedor == null || fornecedor.equals("")) {
			return null;
		} else {
			return ((Fornecedor) fornecedor).getNome();

		}
	}

}
