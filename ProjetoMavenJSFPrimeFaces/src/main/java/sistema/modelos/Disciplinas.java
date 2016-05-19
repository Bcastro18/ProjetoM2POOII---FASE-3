package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Disciplinas implements Serializable  {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codDisc;
	private String nome;
	
	@OneToMany(mappedBy="disciplina")
	private ArrayList<Conteudos> conteudos = new ArrayList<Conteudos>();
	
	@ManyToOne
	private Professor professor;
	public int getCodDisc() {
		return codDisc;
	}
	public void setCodDisc(int codDisc) {
		this.codDisc = codDisc;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Conteudos> getConteudos() {
		return conteudos;
	}
	public void setConteudos(ArrayList<Conteudos> conteudos) {
		this.conteudos = conteudos;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public void addProfessor(Professor professor)
	{
		this.professor = professor;
		
	}
	
	public void addConteudos(Conteudos conteudo){
		conteudos.add(conteudo);
	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codDisc;
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
		Disciplinas other = (Disciplinas) obj;
		if (codDisc != other.codDisc)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	

}
