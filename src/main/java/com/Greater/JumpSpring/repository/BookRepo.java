package com.Greater.JumpSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Greater.JumpSpring.dto.Book;

public interface BookRepo extends JpaRepository<Book, Integer>
{

}
