package com.example.project.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Models.Book;
import com.example.project.Models.BorrowBook;
import com.example.project.service.BookService;
import com.example.project.service.BorrowBookService;

@RestController
@RequestMapping("/borrowbook")
public class BorrowBookController {

	@Autowired
	private BorrowBookService borrowBookService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllBorrowBooks() {
		return ResponseEntity.ok(this.borrowBookService.getAllBorrowBooks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBoorowBook(@PathVariable int id){
		BorrowBook b=this.borrowBookService.getABorrowBook(id);
		if(b!=null) {
			return ResponseEntity.ok(b);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> addBorrowBook(@RequestBody BorrowBook borrowBook, @PathVariable int id){
		Book book=this.bookService.findABook(id);
		borrowBook.setBook(book);
		BorrowBook b=this.borrowBookService.saveborrowBook(borrowBook);
		if(b!=null) {
			return ResponseEntity.ok(b);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
