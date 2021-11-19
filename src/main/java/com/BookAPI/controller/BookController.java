package com.BookAPI.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookAPI.model.Book;
import com.BookAPI.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/")
public class BookController {
	@Autowired
	BookRepository bookRepository;
	// get all book details
    @GetMapping("/books")
	public List<Book> getAllStudents()
	{
    	Book b1 =null;
		return bookRepository.findAll();
	}
	// get book by id
    @GetMapping("/books/{bid}")
    public ResponseEntity<Book> getStudentById(@PathVariable(value = "bid") int bid)
    {
    	Book book= bookRepository.findById(bid).orElse(null);
    	return ResponseEntity.ok().body(book);
    	
    }
    @PostMapping("/books")
    public Book addStudents(@Validated @RequestBody Book book)
    {
    	return bookRepository.save(book);
    }
	
    @PutMapping("/books/{bid}")
    public ResponseEntity<Book> addStudentById(@PathVariable(value = "bid") int bid,@Validated @RequestBody Book bookDetails)
    {
    	Book book=bookRepository.findById(bid).orElse(null);
    	book.setName(bookDetails.getName());
    	//return ResponseEntity.ok().body(student);
    	final Book updatedBook= bookRepository.save(book);
    	return ResponseEntity.ok().body(updatedBook);
    	
    }
    @DeleteMapping("/books/{bid}")
    public Map<String,Boolean> deleteStudent(@PathVariable(name = "bid") int bid)
    {
    	Book book = bookRepository.findById(bid).orElse(null);
    	bookRepository.save(book);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
    }
}
