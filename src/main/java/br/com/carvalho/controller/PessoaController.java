package br.com.carvalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.carvalho.domain.Pessoa;
import br.com.carvalho.repository.PessoaRepository;

@Controller
@RequestMapping(path = "/user")
public class PessoaController {
	
	   @Autowired
	    private PessoaRepository pessoaRepository;


	    @PostMapping(path = "/add")
	    public @ResponseBody String addNewUser(@RequestBody String firstName, @RequestBody String lastName, @RequestBody String email) {

	        Pessoa user = new Pessoa();
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setEmail(email);
	        pessoaRepository.save(user);
	        return "User Created";
	    }

	    @GetMapping(path = "/all")
	    public @ResponseBody Iterable < Pessoa > getAllUsers() {
	        return pessoaRepository.findAll();
	    }
}
