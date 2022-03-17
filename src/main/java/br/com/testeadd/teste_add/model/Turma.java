package br.com.testeadd.teste_add.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_turma")
public class Turma {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_turma; 
	
	@NotNull (message = "O atributo nome é obrigatório")
	@Size (min = 02, max = 50, message = "O atributo nome deve conter no minimo 02 e no máximo 50 caracteres")
	private String nome; 
	
	@NotNull (message = "O atributo capacidade é obrigatório")
	private long capacidade;
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("turma")
	private List<Aluno> aluno;
	
	@ManyToOne
	@JsonIgnoreProperties("turma")
	private Escola escola;

	public long getId_turma() {
		return id_turma;
	}

	public void setId_turma(long id_turma) {
		this.id_turma = id_turma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(long capacidade) {
		this.capacidade = capacidade;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
}
