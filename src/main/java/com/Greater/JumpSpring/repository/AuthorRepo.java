package com.Greater.JumpSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Greater.JumpSpring.dto.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer>
{

}
