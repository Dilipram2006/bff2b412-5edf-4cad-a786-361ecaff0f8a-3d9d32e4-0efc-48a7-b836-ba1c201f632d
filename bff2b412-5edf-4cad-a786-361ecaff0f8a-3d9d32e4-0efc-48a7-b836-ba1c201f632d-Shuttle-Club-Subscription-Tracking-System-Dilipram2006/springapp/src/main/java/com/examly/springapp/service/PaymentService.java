package com.examly.springapp.service;

import com.examly.springapp.model.Payment;
import java.util.List;

public interface PaymentService {

  Payment savePayment(Payment payment);

  List<Payment> getAllPayments();
}

