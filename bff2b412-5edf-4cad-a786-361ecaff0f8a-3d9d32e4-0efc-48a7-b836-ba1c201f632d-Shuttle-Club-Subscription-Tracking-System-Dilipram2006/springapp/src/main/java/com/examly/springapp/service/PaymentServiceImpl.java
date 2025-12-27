package com.examly.springapp.service;

import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  @Override
  public Payment savePayment(Payment payment) {
    return paymentRepository.save(payment);
  }

  @Override
  public List<Payment> getAllPayments() {
    return paymentRepository.findAll();
  }
}

