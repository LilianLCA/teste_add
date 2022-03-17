package br.com.testeadd.teste_add.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testeadd.teste_add.model.Aluno;
import br.com.testeadd.teste_add.repository.AlunoRepository;



@RestController
@RequestMapping ("/aluno")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class AlunoController {

	@Autowired
	public AlunoRepository alunoRepository;
	
	@PostMapping("/{cadastrar}")
	public ResponseEntity<Aluno> postAluno (@Valid @RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
    }
	
	@GetMapping("/{id_aluno}")
	public ResponseEntity<Aluno> getById(@PathVariable long id_aluno) {
		return alunoRepository.findById(id_aluno)
				.map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{all}")
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	@PutMapping("/{atualizar}")
	public ResponseEntity<Aluno> putAluno (@Valid @RequestBody Aluno aluno) {
		return alunoRepository.findById(aluno.getId_aluno())
				.map(resposta -> ResponseEntity.ok().body(alunoRepository.save(aluno)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id_aluno}")
	public ResponseEntity<?> deleteAluno(@PathVariable long id_aluno) {
		return alunoRepository.findById(id_aluno)
				.map(resposta -> {alunoRepository.deleteById(id_aluno);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
				.orElse(ResponseEntity.notFound().build());
	}
}
