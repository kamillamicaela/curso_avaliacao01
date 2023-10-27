package teste.com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.com.br.entity.Aluno;
import teste.com.br.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> listaTodos(){
	return repository.findAll();
	}
	
	public Aluno procuraPorId(Integer id){
		return repository.findById(id).get();
	}
	
	public String incluirAluno(Aluno aluno) {
		repository.save(aluno);
		return "Cadastro incluido com sucesso!";
	}
	
	public String editarAluno(Integer id, Aluno aluno) {
		Aluno response = repository.findById(id).get();
		
		response.setNome(aluno.getNome());
		response.setCpf(aluno.getCpf());
		response.setTelefone(aluno.getTelefone());
		response.setEmail(aluno.getEmail());
		
		repository.save(response);
		return "Cadastro alterado com sucesso!";
	}
	
	public String excluirAluno(Integer id) {
		Aluno response = repository.findById(id).get();
		repository.delete(response);
		
		return "Cadastro excluido com sucesso!";
	}
}

