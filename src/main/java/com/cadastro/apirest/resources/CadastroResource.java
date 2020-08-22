package com.cadastro.apirest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.apirest.models.Cadastro;
import com.cadastro.apirest.repository.CadastroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Cadastro")
public class CadastroResource {
	
	@Autowired
	CadastroRepository cadastroRepository;
	
	@ApiOperation(value="Retorna uma lista de Cadastros")
	@GetMapping("/cadastros")
	public List<Cadastro> listaCadastros(){
		return cadastroRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um cadastro unico")
	@GetMapping("/cadastro/{id}")
	public Cadastro listaCadastroUnico(@PathVariable(value="id") long id){
		return cadastroRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um cadastro")
	@PostMapping("/cadastro")
	public Cadastro salvaCadastro(@RequestBody @Valid Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
	@ApiOperation(value="Deleta um cadastro")
	@DeleteMapping("/cadastro")
	public void deletaCadastro(@RequestBody @Valid Cadastro cadastro) {
		cadastroRepository.delete(cadastro);
	}
	
	@ApiOperation(value="Atualiza um cadastro")
	@PutMapping("/cadastro")
	public Cadastro atualizaCadastro(@RequestBody @Valid Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	 

}
