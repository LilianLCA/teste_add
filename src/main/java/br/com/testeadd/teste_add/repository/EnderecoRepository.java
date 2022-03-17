package br.com.testeadd.teste_add.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testeadd.teste_add.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	public List<Endereco> findAllByLogradouroContainingIgnoreCase (String logradouro);
	
}
