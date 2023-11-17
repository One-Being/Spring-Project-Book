package com.Greater.JumpSpring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Greater.JumpSpring.dto.Author;
import com.Greater.JumpSpring.repository.AuthorRepo;

@Repository
public class AuthorDao {
	@Autowired
	AuthorRepo repo;
	
	public Author saveAuthor( Author b) 
	{
		return repo.save(b);
	}
	
	
	public Author findAuthor(int id) 
	{
		Optional<Author> opAuthor = repo.findById(id);
		if (opAuthor.isPresent()) 
		{
			return opAuthor.get();
		}
		 return null;
	}
	
	public Author deleteAuthor(int id) 
	{
		Author exauth = findAuthor(id);
		
		if (exauth != null) 
		{
			repo.delete(exauth);
			return exauth;
		}
		 return null;
	}
	
	public List<Author> findAll() {
		List <Author> authlist = repo.findAll();
		return  authlist;
	}
	public Author updateAuthor(Author a , int id) 
	{
		Author exauth = findAuthor(id);
		if (exauth != null) 
		{
			if (a.getAuthname()==(null)) 
			{
				a.setAuthname(exauth.getAuthname());
				
			}
			if(a.getContact()<=0) {
				
				a.setContact(exauth.getContact());
			}
			if (a.getBook() == null) 
			{
				a.setBook(exauth.getBook());
				
			}
			a.setAuthid(id);
			return repo.save(a);
		}
		 return null;
	}
	
	
}
