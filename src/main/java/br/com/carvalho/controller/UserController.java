package br.com.carvalho.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carvalho.domain.User;
import br.com.carvalho.repository.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	   @Autowired
	    private UserRepository userRepository;


	    @PostMapping(path = "/add")
	    public User addNewUser(@RequestBody String firstName, @RequestBody String lastName, @RequestBody String email) {

	        User user = new User();
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setEmail(email);
	        userRepository.save(user);
	      return user;
	    }

	    @GetMapping(path = "/all")
	    public Iterable < User > getAllUsers() {
	        return userRepository.findAll();
	    }
}
