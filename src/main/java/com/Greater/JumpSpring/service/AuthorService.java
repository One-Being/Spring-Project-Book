package com.Greater.JumpSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Greater.JumpSpring.config.ResponseStructure;
import com.Greater.JumpSpring.dao.AuthorDao;
import com.Greater.JumpSpring.dao.BookDao;
import com.Greater.JumpSpring.dto.Author;
import com.Greater.JumpSpring.dto.Book;

@Service
public class AuthorService {
	
	@Autowired
	AuthorDao dao;
	
	@Autowired
	BookDao bdao;
	
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(Author auth) 
	{
		ResponseStructure<Author> repost = new ResponseStructure<>();
		repost.setData(dao.saveAuthor(auth));
		repost.setMessage("Author Has Been Saved");
		repost.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Author>>(repost,HttpStatus.CREATED );
		
	}
	
	public ResponseEntity<ResponseStructure<Author>> deleteAuthor(int id) {
		ResponseStructure<Author> repost = new ResponseStructure<>();
		if (dao.findAuthor(id)!=null) {
			
			repost.setData(dao.deleteAuthor(id));
			repost.setMessage("Author Has Been Deleted");
			repost.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Author>>(repost,HttpStatus.OK );
		}
		else {
			repost.setMessage("Author not Found");
			repost.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Author>>(repost,HttpStatus.NOT_FOUND );
		}
	}
	
	public ResponseEntity<ResponseStructure<Author>> updateAuthor(Author b,int id ) 
	{
		ResponseStructure<Author> repost = new ResponseStructure<>();
		if (dao.findAuthor(id)!=null) {
			repost.setData(dao.updateAuthor(b,id));
			repost.setMessage(" Author  Has Been Updated");
			repost.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Author>>(repost,HttpStatus.OK );
		}
		else {
			repost.setMessage("Author not Found");
			repost.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Author>>(repost,HttpStatus.NOT_FOUND );
		}
		
	}
	
	public  ResponseEntity<ResponseStructure<Author>> findAuthor( int id) 
	{
		ResponseStructure<Author> repost = new ResponseStructure<>();
		if (dao.findAuthor(id)!=null)
		{
			
			repost.setData(dao.findAuthor(id));
			repost.setMessage("Author Found");
			repost.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Author>>(repost,HttpStatus.FOUND );
		}
		else {
			repost.setMessage("Author not Found");
			repost.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Author>>(repost,HttpStatus.NOT_FOUND );
		}
	}
	
	public ResponseEntity<ResponseStructure<Author>>  assignBookToAuthor(int authid, int bookid) 
	{ 
		Author auth = dao.findAuthor(authid);
		Book book = bdao.findBook(bookid);
		
		if(auth!= null) {
			if(book!=null) {
				ResponseStructure<Author> repost = new ResponseStructure<>();
				auth.setBook(book);
				repost.setData(dao.updateAuthor(auth, authid));
				repost.setMessage("Book has been  assigned to author");
				repost.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Author>>(repost,HttpStatus.OK );
			}
			
			return null;
		}
		return null;
	}
	
}
