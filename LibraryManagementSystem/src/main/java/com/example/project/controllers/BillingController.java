package com.example.project.controllers;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Models.Billing;
import com.example.project.Models.BorrowBook;
import com.example.project.service.BillingService;
import com.example.project.service.BorrowBookService;

@RestController
@RequestMapping("/billing")
public class BillingController {

	@Autowired
	private BillingService billingService;
	
	@Autowired
	private BorrowBookService borrowService;
	
	@PostMapping("/{borrowbookid}")
	public ResponseEntity<?> generateBill(@RequestBody Billing billing, @PathVariable int borrowbookid){
		BorrowBook borrowBook=this.borrowService.getABorrowBook(borrowbookid);
		Date d1=borrowBook.getBookingDate();
		Date d2=billing.getReturnDate();
		long diff = d2.getTime() - d1.getTime();
		double n=(diff / (1000*60*60*24))-borrowBook.getNo_Of_Days()+1;
		double amt=(borrowBook.getChargePerDay()*borrowBook.getNo_Of_Days())+(billing.getFinePerDay()*n);
		billing.setBorrowBook(borrowBook);
		billing.setBillAmount(amt);
		Billing b=this.billingService.saveBill(billing);
		if(b!=null) {
			return ResponseEntity.ok(b);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/getbill/{id}")
	public ResponseEntity<?> getBill(@PathVariable int id){
		Billing b=this.billingService.findBill(id);
		if(b!=null) {
			return ResponseEntity.ok(b);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
