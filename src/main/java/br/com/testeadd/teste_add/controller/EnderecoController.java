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

import br.com.testeadd.teste_add.model.Endereco;
import br.com.testeadd.teste_add.repository.EnderecoRepository;


@RestController
@RequestMapping ("/endereco")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class EnderecoController {
	
	@Autowired
	public EnderecoRepository enderecoRepository;
	
	
	@PostMapping("/{cadastrar}")
	public ResponseEntity<Endereco> postEndereco (@Valid @RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
    }
	
	@GetMapping("/{id_endereco}")
	public ResponseEntity<Endereco> getById(@PathVariable long id_endereco) {
		return enderecoRepository.findById(id_endereco)
				.map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{all}")
	public List<Endereco> findAll(){
		return enderecoRepository.findAll();
	}
	
	@PutMapping("/{atualizar}")
	public ResponseEntity<Endereco> putEndereco (@Valid @RequestBody Endereco endereco) {
		return enderecoRepository.findById(endereco.getId_endereco())
				.map(resposta -> ResponseEntity.ok().body(enderecoRepository.save(endereco)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id_endereco}")
	public ResponseEntity<?> deleteEndereco(@PathVariable long id_endereco) {
		return enderecoRepository.findById(id_endereco)
				.map(resposta -> {enderecoRepository.deleteById(id_endereco);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
				.orElse(ResponseEntity.notFound().build());
	}
}
