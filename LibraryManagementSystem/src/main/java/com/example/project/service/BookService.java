package com.example.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Models.Book;
import com.example.project.Repository.BookRepository;
import com.example.project.Repository.BorrowBookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BorrowBookRepository borrowBookRepository;

	public List<Book> findAllBooks() {
		return this.bookRepository.findAll();
	}

	public Book findABook(int id) {
		return this.bookRepository.findById(id).orElse(null);
	}

	public Book addABook(Book book) {
		Book b = this.bookRepository.save(book);
		return b;
	}

	public Object findBooksBydate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteABook(int id) {
		this.bookRepository.deleteById(id);

	}

}
