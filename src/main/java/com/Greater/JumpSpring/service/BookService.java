package com.Greater.JumpSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Greater.JumpSpring.config.ResponseStructure;
import com.Greater.JumpSpring.dao.BookDao;
import com.Greater.JumpSpring.dto.Book;

@Service
public class BookService {

	@Autowired
	BookDao dao;
	
	ResponseStructure<Book> repost;
	
	public ResponseStructure<Book> saveBook(Book b) 
	{
		ResponseStructure<Book> repost = new ResponseStructure<>();
		repost.setData(dao.saveBook(b));
		repost.setMessage("Book Has Been Saved");
		repost.setStatus(HttpStatus.CREATED.value());
		return repost;
		
	}
	
	public ResponseStructure<Book> deleteBook(int id) {
		ResponseStructure<Book> repost = new ResponseStructure<>();
		repost.setData(dao.deleteBook(id));
		repost.setMessage("Book Has Been Deleted");
		repost.setStatus(HttpStatus.OK.value());
		return repost;
	}
	
	public  ResponseStructure<Book> updateBook(Book b,int id ) 
	{
		ResponseStructure<Book> repost = new ResponseStructure<>();
		repost.setData(dao.updateBook(b,id));
		repost.setMessage("Book With id :"+id+" Has Been Updated");
		repost.setStatus(HttpStatus.OK.value());
		return repost;
		
	}
	
	public List<Book> findAllBook() {
		return dao.findAll();
	}
	
	public  ResponseStructure<Book> findBook( int id) 
	{
		ResponseStructure<Book> repost = new ResponseStructure<>();
		repost.setData(dao.findBook(id));
		repost.setMessage("Book Found");
		repost.setStatus(HttpStatus.FOUND.value());
		return repost;
	}

}
