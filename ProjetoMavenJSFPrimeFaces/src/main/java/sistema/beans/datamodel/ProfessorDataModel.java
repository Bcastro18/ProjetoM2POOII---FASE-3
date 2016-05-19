package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import sistema.modelos.Disciplinas;
import sistema.modelos.Professor;
import sistema.service.ProfessorService;

public class ProfessorDataModel extends ListDataModel<Professor> implements SelectableDataModel<Professor> {
	
private ProfessorService servico = new ProfessorService();
	
	public ProfessorDataModel()
	{
		
	}

	public ProfessorDataModel(List <Professor> list)
	{
	   super(list);	
	}

	
	@Override
	public Professor getRowData(String rowKey) {
		
		for(Professor f: servico.getProfessores())
		   if(Integer.parseInt(rowKey) ==  f.getMatricula())
			   return f;
		
		return null;
	}

	@Override
	public Object getRowKey(Professor professor) {
		return professor.getMatricula();
	}

}