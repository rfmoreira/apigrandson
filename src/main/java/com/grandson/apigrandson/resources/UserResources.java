package com.grandson.apigrandson.resources;

import java.util.List;

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

import com.grandson.apigrandson.models.User;
import com.grandson.apigrandson.repository.UserRespository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Grandson")
@CrossOrigin(origins="*")
public class UserResources {

	@Autowired
	UserRespository userRespository;
	
	@GetMapping("/users")
	@ApiOperation(value="Retorna lista de usuarios")
	public List<User> listaUsers(){
		return userRespository.findAll();
	}
	
	@GetMapping("/user/{id}")
	@ApiOperation(value="Retorna Usuario")
	public User listaUser(@PathVariable(value="id") long id){
		return userRespository.findById(id);
	}
	
	@PostMapping("/user")
	@ApiOperation(value="Salva Usuario")
	public User salbaUser(@RequestBody User user) {
		return userRespository.save(user);
	}
	
	@DeleteMapping("/user")
	@ApiOperation(value="Deleta Usuario")
	public void delUser(@RequestBody User user) {
		userRespository.delete(user);
	}
	
	@PutMapping("/user")
	@ApiOperation(value="Atualiza Usuario")
	public User updateUser(@RequestBody User user) {
		return userRespository.save(user);
	}
}


