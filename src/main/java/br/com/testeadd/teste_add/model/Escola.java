package br.com.testeadd.teste_add.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_escola")
public class Escola {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_escola; 
	
	@NotNull (message = "O atributo nome é obrigatório")
	@Size (min = 03, max = 70, message = "O atributo nome deve conter no minimo 03 e no máximo 70 caracteres")
	private String nome; 
	
	@NotNull (message = "O atributo endereço é obrigatório")
	@Size (min = 05, max = 100, message = "O atributo endereço deve conter no minimo 05 e no máximo 100 caracteres")
	private String endereco;
	
	@OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("escola")
	private List<Turma> turma;

	public long getId_escola() {
		return id_escola;
	}

	public void setId_escola(long id_escola) {
		this.id_escola = id_escola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
	
}
