package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Perguntas;
import sistema.service.PerguntaService;

@FacesConverter("converterPergunta")
public class PerguntasConverter implements Converter {

	private PerguntaService servico = new PerguntaService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Perguntas f : servico.getPerguntas())
				 if(f.getEnunciado().equals(value))
				  	return f;
					
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object professor) {
		if (professor == null || professor.equals("")) {
			return null;
		} else {
			return ((Perguntas) professor).getEnunciado();

		}
	}

}

