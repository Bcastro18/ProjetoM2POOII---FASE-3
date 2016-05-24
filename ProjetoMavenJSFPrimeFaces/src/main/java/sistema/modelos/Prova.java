package sistema.modelos;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Prova {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codProva;
	private String turma;
	private String curso;
	private String faculdade;
	private String nome;
	private Date data_App;
	
	@ManyToMany
	private ArrayList<Perguntas> perguntas = new ArrayList<Perguntas>();
	
	public int getCodProva() {
		return codProva;
	}
	public void setCodProva(int codProva) {
		this.codProva = codProva;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getFaculdade() {
		return faculdade;
	}
	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_App() {
		return data_App;
	}
	public void setData_App(Date data_App) {
		this.data_App = data_App;
	}
	public ArrayList<Perguntas> getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(ArrayList<Perguntas> perguntas) {
		this.perguntas = perguntas;
	}
	
	public void addPergunta(Perguntas pergunta){
		perguntas.add(pergunta);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codProva;
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
		Prova other = (Prova) obj;
		if (codProva != other.codProva)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
