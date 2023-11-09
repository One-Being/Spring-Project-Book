package com.Greater.JumpSpring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.Greater.JumpSpring.dto.Book;
import com.Greater.JumpSpring.repository.BookRepo;

@Repository
public class BookDao {
	
	@Autowired
	BookRepo repo;
	
	@Autowired
	Book bk;
	
	public Book saveBook( Book b) 
	{
		return repo.save(b);
	}
	
	public Book findBook(int id) 
	{
		Optional<Book> opBook = repo.findById(id);
		if (opBook.isPresent()) 
		{
			return opBook.get();
		}
		 return null;
	}
	
	public Book deleteBook(int id) 
	{
		Book exbook = findBook(id);
		
		if (exbook != null) 
		{
			repo.delete(exbook);
			return exbook;
		}
		 return null;
	}
	
	public List<Book> findAll() {
		List <Book> booklist = repo.findAll();
		return  booklist;
	}
	public Book updateBook(Book b , int id) 
	{
		Book exbook = findBook(id);
		if (exbook != null) 
		{
			if (b.getName()==(null)) 
			{
				b.setName(exbook.getName());
				
			}
			if(b.getPrice()<=0) {
				
				b.setPrice(exbook.getPrice());
			}
			if (b.getCopies()<=0) 
			{
				b.setCopies(exbook.getCopies());
				
			}
			b.setId(id);
			return repo.save(b);
		}
		 return null;
	}
	
}
