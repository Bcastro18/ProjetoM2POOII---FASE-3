package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@FacesConverter("converterProfessor")
public class ProfessorConverter implements Converter {

	private ProfessorService servico = new ProfessorService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Professor f : servico.getProfessores())
				 if(f.getNome().equals(value))
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
			return ((Professor) professor).getNome();

		}
	}

}

