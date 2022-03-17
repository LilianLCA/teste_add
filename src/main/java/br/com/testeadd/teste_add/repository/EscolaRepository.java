package br.com.testeadd.teste_add.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testeadd.teste_add.model.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {

	public List<Escola> findAllByNomeContainingIgnoreCase (String nome);
}
