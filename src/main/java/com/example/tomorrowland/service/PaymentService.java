package com.example.tomorrowland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tomorrowland.entity.Payment;
import com.example.tomorrowland.exception.PaymentNotFoundException;
import com.example.tomorrowland.repository.PaymentRepository;

@Service
public class PaymentService {
	
	private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
    }
    
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    
	/*
	 * public Payment updatePayment(Long id, Payment payment) { Optional<Payment>
	 *  
	 * }
	 */
    
    public void deletePayment(Long id) {
    	paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
    	paymentRepository.deleteById(id);
    }

}
