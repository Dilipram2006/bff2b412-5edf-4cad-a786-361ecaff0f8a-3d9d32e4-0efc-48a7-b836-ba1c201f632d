package com.examly.springapp.controller;

import com.examly.springapp.model.Membership;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

  @GetMapping("/{id}")
  public Membership getMembership(@PathVariable int id) {
    return new Membership();
  }
}

