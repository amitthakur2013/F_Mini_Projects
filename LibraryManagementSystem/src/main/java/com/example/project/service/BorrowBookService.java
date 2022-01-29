package com.example.project.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Models.Book;
import com.example.project.Models.BorrowBook;
import com.example.project.Models.User;
import com.example.project.Repository.BookRepository;
import com.example.project.Repository.BorrowBookRepository;
import com.example.project.Repository.UserRepository;

@Service
public class BorrowBookService {
	
	@Autowired
	private BorrowBookRepository borrowBookRepository;

	public List<BorrowBook> getAllBorrowBooks() {
		return this.borrowBookRepository.findAll();
	}

	public BorrowBook getABorrowBook(int id) {
		return this.borrowBookRepository.findById(id).orElse(null);
	}

	public BorrowBook saveborrowBook(BorrowBook borrowBook) {
		return this.borrowBookRepository.save(borrowBook);
	}

	
}
