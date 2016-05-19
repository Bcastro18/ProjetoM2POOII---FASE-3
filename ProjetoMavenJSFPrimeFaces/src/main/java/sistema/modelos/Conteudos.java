package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Conteudos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codConteudo;
	private String nome;
	
	@ManyToOne
	private Disciplinas disciplina;
	
	
	//private ArrayList<Perguntas> perguntas = new ArrayList<Perguntas>();
	
	public int getCodConteudo() {
		return codConteudo;
	}
	public void setCodConteudo(int codConteudo) {
		this.codConteudo = codConteudo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Disciplinas getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplinas disciplina) {
		this.disciplina = disciplina;
	}
	/*public ArrayList<Perguntas> getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(ArrayList<Perguntas> perguntas) {
		this.perguntas = perguntas;
	}
	
	public void addPerguntas(Perguntas pergunta){
		perguntas.add(pergunta);
	
	}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codConteudo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conteudos other = (Conteudos) obj;
		if (codConteudo != other.codConteudo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

		

}
