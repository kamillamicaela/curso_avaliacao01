package teste.com.br.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.com.br.entity.Aluno;
import teste.com.br.service.AlunoService;

@RestController
@RequestMapping(value="/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService service;

	@GetMapping
	public List<Aluno> listaTodos(){
		return service.listaTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Aluno procuraPorId(@PathVariable Integer id) {
		return service.procuraPorId(id);
	}
	
	@PostMapping
	public String incluirUsuario(@RequestBody Aluno aluno) {
		String response = service.incluirAluno(aluno);
		return response;
	}
	
	@PutMapping(value= "/{id}")
	public String editarAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
	String response = service.editarAluno(id, aluno);
	return response;
	}
	
	@DeleteMapping(value="/{id}")
	public void excluirAluno(@PathVariable Integer id) {
		service.excluirAluno(id);
	}
}
