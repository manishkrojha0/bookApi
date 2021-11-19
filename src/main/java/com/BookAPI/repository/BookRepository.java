package com.BookAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookAPI.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>
{

}
