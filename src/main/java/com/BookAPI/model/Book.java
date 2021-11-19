package com.BookAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_details")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	private String name;
	private String author;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", name=" + name + ", author=" + author + "]";
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(int bid, String name, String author) {
		super();
		this.bid = bid;
		this.name = name;
		this.author = author;
	}

}
