package br.com.testeadd.teste_add.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testeadd.teste_add.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

	public List<Turma> findAllByNomeContainingIgnoreCase (String nome);
}
