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

import br.com.testeadd.teste_add.model.Escola;
import br.com.testeadd.teste_add.repository.EscolaRepository;



@RestController
@RequestMapping ("/escola")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class EscolaController {

	@Autowired
	public EscolaRepository escolaRepository;
	
	@PostMapping("/{cadastrar}")
	public ResponseEntity<Escola> postEscola (@Valid @RequestBody Escola escola) {
        return ResponseEntity.status(HttpStatus.CREATED).body(escolaRepository.save(escola));
    }
	
	@GetMapping("/{id_escola}")
	public ResponseEntity<Escola> getByIdEscola(@PathVariable long id_escola) {
		return escolaRepository.findById(id_escola)
				.map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{all}")
	public List<Escola> findAll(){
		return escolaRepository.findAll();
	}
	
	@PutMapping("/{atualizar}")
	public ResponseEntity<Escola> putEscola (@Valid @RequestBody Escola escola) {
		return escolaRepository.findById(escola.getId_escola())
				.map(resposta -> ResponseEntity.ok().body(escolaRepository.save(escola)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id_escola}")
	public ResponseEntity<?> deleteEscola(@PathVariable long id_escola) {
		return escolaRepository.findById(id_escola)
				.map(resposta -> {escolaRepository.deleteById(id_escola);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
				.orElse(ResponseEntity.notFound().build());
	}
}
