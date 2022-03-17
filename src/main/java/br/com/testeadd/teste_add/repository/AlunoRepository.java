package br.com.testeadd.teste_add.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testeadd.teste_add.model.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
 
	public List<Aluno> findAllByNomeContainingIgnoreCase (String nome);

}
