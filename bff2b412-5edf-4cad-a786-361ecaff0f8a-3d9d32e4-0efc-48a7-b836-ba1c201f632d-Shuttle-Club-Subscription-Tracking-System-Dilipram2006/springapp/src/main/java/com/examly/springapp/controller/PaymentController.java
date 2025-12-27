package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

  @GetMapping("/{id}")
  public String getPayment(@PathVariable int id) {
    return "Payment";
  }
}

