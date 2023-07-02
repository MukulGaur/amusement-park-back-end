package com.example.tomorrowland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tomorrowland.entity.Payment;
import com.example.tomorrowland.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	private PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.createPayment(payment), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Payment> getAllUsers(){
		return paymentService.getAllPayments();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id, @RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.getPaymentById(id), HttpStatus.OK);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Payment> updatePaymentById(@PathVariable("id") Long id, @RequestBody Payment payment){
//		return new ResponseEntity<Payment>(paymentService.updatePayment(payment, id), HttpStatus.OK);
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		paymentService.deletePayment(id);
		return new ResponseEntity<String>("Payment record deleted successfully !", HttpStatus.OK);
	}

}
