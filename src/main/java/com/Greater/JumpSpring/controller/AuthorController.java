package com.Greater.JumpSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Greater.JumpSpring.config.ResponseStructure;
import com.Greater.JumpSpring.dto.Author;
import com.Greater.JumpSpring.service.AuthorService;
@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(@RequestBody Author auth) 
	{
		return service.saveAuthor(auth);
		
	}
	
	@DeleteMapping
	public  ResponseEntity<ResponseStructure<Author>> deleteBook(@RequestParam int id) 
	{
		return service.deleteAuthor(id);
	}
	
	@PutMapping
	public  ResponseEntity<ResponseStructure<Author>> updateAuthor(@RequestBody Author b, @RequestParam int id) 
	{
		return service.updateAuthor(b,id);
		
	}
	
	@GetMapping
	public  ResponseEntity<ResponseStructure<Author>> findAuthor(@RequestParam int id) 
	{
		return service.findAuthor(id);
	}
	
	@PutMapping("/assignbook")
	public  ResponseEntity<ResponseStructure<Author>> assignBookToAuthor(@RequestParam int authid, @RequestParam int bid) 
	{
		return service.assignBookToAuthor(authid, bid);
		
	}
	
	
	
	
}

