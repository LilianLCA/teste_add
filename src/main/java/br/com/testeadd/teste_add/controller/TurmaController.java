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

import br.com.testeadd.teste_add.model.Turma;
import br.com.testeadd.teste_add.repository.TurmaRepository;


@RestController
@RequestMapping ("/turma")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class TurmaController {

	@Autowired
	public TurmaRepository turmaRepository;
	
	@PostMapping("/{cadastrar}")
	public ResponseEntity<Turma> postTurma (@Valid @RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaRepository.save(turma));
    }
	
	@GetMapping("/{id_turma}")
	public ResponseEntity<Turma> getByIdTurma(@PathVariable long id_turma) {
		return turmaRepository.findById(id_turma)
				.map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{all}")
	public List<Turma> findAll(){
		return turmaRepository.findAll();
	}
	
	@PutMapping("/{atualizar}")
	public ResponseEntity<Turma> putTurma (@Valid @RequestBody Turma turma) {
		return turmaRepository.findById(turma.getId_turma())
				.map(resposta -> ResponseEntity.ok().body(turmaRepository.save(turma)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id_turma}")
	public ResponseEntity<?> deleteTurma(@PathVariable long id_turma) {
		return turmaRepository.findById(id_turma)
				.map(resposta -> {turmaRepository.deleteById(id_turma);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
				.orElse(ResponseEntity.notFound().build());
	}
}
