package com.Greater.JumpSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.Greater.JumpSpring.config.ResponseStructure;
import com.Greater.JumpSpring.dto.Book;
import com.Greater.JumpSpring.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService service;
	
	@PostMapping
	public ResponseStructure<Book> saveBook(@RequestBody Book b) 
	{
		return service.saveBook(b);
		
	}
	
	@DeleteMapping
	public  ResponseStructure<Book>deleteBook(@RequestParam int id) 
	{
		return service.deleteBook(id);
	}
	
	
	@PutMapping
	public  ResponseStructure<Book> updateBook(@RequestBody Book b, @RequestParam int id) 
	{
		return service.updateBook(b,id);
		
	}
	
	@GetMapping("/findallbooks")
	public List<Book> findAllBook() 
	{
		return service.findAllBook();
	}
	
	@GetMapping
	public  ResponseStructure<Book> findBook(@RequestParam int id) 
	{
		return service.findBook(id);
	}

}
