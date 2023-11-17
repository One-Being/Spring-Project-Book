package com.Greater.JumpSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Greater.JumpSpring.config.ResponseStructure;
import com.Greater.JumpSpring.dao.BookDao;
import com.Greater.JumpSpring.dto.Book;

@Service
public class BookService {

	@Autowired
	BookDao dao;
	
	ResponseStructure<Book> repost;
	
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book b) 
	{
		ResponseStructure<Book> repost = new ResponseStructure<>();
		repost.setData(dao.saveBook(b));
		repost.setMessage("Book Has Been Saved");
		repost.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Book>>(repost,HttpStatus.CREATED );
		
	}
	
	public ResponseEntity<ResponseStructure<Book>> deleteBook(int id) {
		ResponseStructure<Book> repost = new ResponseStructure<>();
		if (dao.findBook(id)!=null) {
			
			repost.setData(dao.deleteBook(id));
			repost.setMessage("Book Has Been Deleted");
			repost.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(repost,HttpStatus.OK );
		}
		else {
			repost.setMessage("Book not Found");
			repost.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Book>>(repost,HttpStatus.NOT_FOUND );
		}
	}
	
	public ResponseEntity<ResponseStructure<Book>> updateBook(Book b,int id ) 
	{
		ResponseStructure<Book> repost = new ResponseStructure<>();
		if (dao.findBook(id)!=null) {
			repost.setData(dao.updateBook(b,id));
			repost.setMessage("Book With id :"+id+" Has Been Updated");
			repost.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(repost,HttpStatus.OK );
		}
		else {
			repost.setMessage("Book not Found");
			repost.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Book>>(repost,HttpStatus.NOT_FOUND );
		}
		
	}
	
	public ResponseEntity<ResponseStructure<List<Book>>>findAllBook() {
		ResponseStructure<List<Book>> repost = new ResponseStructure<>();
		if (!dao.findAll().isEmpty()) {
			
			repost.setData(dao.findAll());
			repost.setMessage("Book Found");
			repost.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Book>>>(repost,HttpStatus.FOUND );
		}
		else {
			repost.setMessage("Book not Found");
			repost.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Book>>>(repost,HttpStatus.NOT_FOUND );
		}
	}
	
	public  ResponseEntity<ResponseStructure<Book>> findBook( int id) 
	{
		ResponseStructure<Book> repost = new ResponseStructure<>();
		if (dao.findBook(id)!=null)
		{
			
			repost.setData(dao.findBook(id));
			repost.setMessage("Book Found");
			repost.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Book>>(repost,HttpStatus.FOUND );
		}
		else {
			repost.setMessage("Book not Found");
			repost.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Book>>(repost,HttpStatus.NOT_FOUND );
		}
	}

}
