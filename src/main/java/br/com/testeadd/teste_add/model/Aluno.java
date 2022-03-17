package br.com.testeadd.teste_add.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_aluno")
public class Aluno {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_aluno; 
	
	@NotNull (message = "O atributo nome é obrigatório")
	@Size (min = 03, max = 70, message = "O atributo nome deve conter no minimo 03 e no máximo 70 caracteres")
	private String nome; 
	
	@NotNull (message = "O atributo data de nascimento é obrigatório")
	private Calendar DataDeNascimento;
	
	@ManyToOne
	@JsonIgnoreProperties("aluno")
	private Turma turma;


	public long getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(long id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataDeNascimento() {
		return DataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		DataDeNascimento = dataDeNascimento;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	} 
	
}
