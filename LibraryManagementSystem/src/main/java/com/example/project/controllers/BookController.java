package com.example.project.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Models.Book;
import com.example.project.service.BookService;
import com.example.project.service.BorrowBookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("")
	public ResponseEntity<?> getAllBooks(){
		return ResponseEntity.ok(this.bookService.findAllBooks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBook(@PathVariable int id){
		Book b=this.bookService.findABook(id);
		if(b!=null) {
			return ResponseEntity.ok(b);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		Book b=this.bookService.addABook(book);
		if(b!=null) {
			return ResponseEntity.ok(b);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id){
		this.bookService.deleteABook(id);
		return ResponseEntity.ok("");

	}
	
	@GetMapping("/day/{date}")
	public ResponseEntity<?> getAllBooksByDate(@PathVariable Date date){
		return ResponseEntity.ok(this.bookService.findBooksBydate(date));
	}
	
	
}
