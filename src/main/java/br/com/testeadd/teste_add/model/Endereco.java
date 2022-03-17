package br.com.testeadd.teste_add.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_endereco; 
	
	@NotNull (message = "O atributo logradouro é obrigatório")
	@Size (min = 05, max = 100, message = "O atributo logradouro deve conter no minimo 05 e no máximo 100 caracteres")
	private String logradouro; 
	
	private String complemento;
	
	@NotNull (message = "O atributo bairro é obrigatório")
	@Size (min = 03, max = 100, message = "O atributo bairro deve conter no minimo 03 e no máximo 100 caracteres")
	private String bairro;
	
	@NotNull (message = "O atributo cidade é obrigatório")
	@Size (min = 03, max = 50, message = "O atributo cidade deve conter no minimo 03 e no máximo 50 caracteres")
	private String cidade;
	
	@NotNull (message = "O atributo estado é obrigatório")
	@Size (min = 03, max = 50, message = "O atributo estado deve conter no minimo 03 e no máximo 50 caracteres")
	private String estado;
	
	@OneToOne
	@JsonIgnoreProperties("endereco")
	private Escola Escola;

	public long getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(long id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Escola getEscola() {
		return Escola;
	}

	public void setEscola(Escola escola) {
		Escola = escola;
	}
	
	
}
