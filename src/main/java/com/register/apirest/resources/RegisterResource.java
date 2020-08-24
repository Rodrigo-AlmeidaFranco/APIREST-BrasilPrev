package com.register.apirest.resources;

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

import com.register.apirest.models.Register;
import com.register.apirest.repository.RegisterRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="Register API REST")
public class RegisterResource {
	
	@Autowired
	RegisterRepository cadastroRepository;
	
	@ApiOperation(value="Return a list of registers")
	@GetMapping("/register")
	public List<Register> listaCadastros(){
		return cadastroRepository.findAll();
	}
	
	@ApiOperation(value="Return a unique register")
	@GetMapping("/register/{id}")
	public Register listaCadastroUnico(@PathVariable(value="id") long id){
		return cadastroRepository.findById(id);
	}
	
	@ApiOperation(value="Save a Register")
	@PostMapping("/register")
	public Register salvaCadastro(@RequestBody @Valid Register cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
	@ApiOperation(value="Delete a register")
	@DeleteMapping("/register")
	public void deletaCadastro(@RequestBody @Valid Register cadastro) {
		cadastroRepository.delete(cadastro);
	}
	
	@ApiOperation(value="Update a register")
	@PutMapping("/register")
	public Register atualizaCadastro(@RequestBody @Valid Register cadastro) {
		return cadastroRepository.save(cadastro);
	}
	 

}
