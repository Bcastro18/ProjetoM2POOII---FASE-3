package sistema.modelos;

import java.io.Serializable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Perguntas implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codPergunta;
	
	private int dificuldade;
	private int tempo_estimado;
	
	@Temporal(value = TemporalType.DATE)
	private Date data_criacao;
	private String enunciado;
	@ManyToMany
	@JoinTable(name="TbContProva", joinColumns={@JoinColumn(name="c_codPerg")})
	private List<Prova> provas = new ArrayList<Prova>();
	
	@ManyToMany
	@JoinTable(name="TbContPerg", joinColumns={@JoinColumn(name="c_codPerg")})
	private List<Conteudos> conteudos = new ArrayList<Conteudos>();
	
	
	
	public  int getCodPergunta() {
		return codPergunta;
	}
	public  void setCodPergunta(int codPergunta) {
		this.codPergunta = codPergunta;
	}
	public  int getDificuldade() {
		return dificuldade;
	}
	public  void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
	public  int getTempo_estimado() {
		return tempo_estimado;
	}
	public  void setTempo_estimado(int tempo_estimado) {
		this.tempo_estimado = tempo_estimado;
	}
	public  Date getData_criacao() {
		return data_criacao;
	}
	public  void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	public  String getEnunciado() {
		return enunciado;
	}
	public  void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public List<Conteudos> getConteudos() {
		return conteudos;
	}
	public void setConteudos(List<Conteudos> conteudos) {
		this.conteudos = conteudos;
	}

	private ArrayList<Byte> imagem = new ArrayList<Byte>();
	
	public void addConteudo(Conteudos conteudo)
	{
		conteudos.add(conteudo);
		
	}
		
	public List<Prova> getProvas() {
		return provas;
	}
	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}
	public void addProva(Prova prova)
	{
		provas.add(prova);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codPergunta;
		result = prime * result + ((data_criacao == null) ? 0 : data_criacao.hashCode());
		result = prime * result + dificuldade;
		result = prime * result + ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
		result = prime * result + tempo_estimado;
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
		Perguntas other = (Perguntas) obj;
		if (codPergunta != other.codPergunta)
			return false;
		if (data_criacao == null) {
			if (other.data_criacao != null)
				return false;
		} else if (!data_criacao.equals(other.data_criacao))
			return false;
		if (dificuldade != other.dificuldade)
			return false;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		if (imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!imagem.equals(other.imagem))
			return false;
		if (tempo_estimado != other.tempo_estimado)
			return false;
		return true;
	}
		

	
	
}

