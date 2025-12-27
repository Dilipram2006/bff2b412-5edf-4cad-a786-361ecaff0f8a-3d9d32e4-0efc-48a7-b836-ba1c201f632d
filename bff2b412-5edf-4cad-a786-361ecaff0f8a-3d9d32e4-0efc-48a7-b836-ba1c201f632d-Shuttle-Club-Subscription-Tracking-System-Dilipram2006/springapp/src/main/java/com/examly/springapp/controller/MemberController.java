package com.examly.springapp.controller;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

  @Autowired
  private MemberService memberService;

  // Day 10 – Create
  @PostMapping
  public ResponseEntity<Member> createMember(@RequestBody Member member) {
    return new ResponseEntity<>(memberService.save(member), HttpStatus.CREATED);
  }

  // Day 10 – Get by ID
  @GetMapping("/{id}")
  public ResponseEntity<Member> getMemberById(@PathVariable int id) {
    return ResponseEntity.ok(memberService.getById(id));
  }

  // Day 10 – Update
  @PutMapping("/{id}")
  public ResponseEntity<Member> updateMember(
      @PathVariable int id,
      @RequestBody Member member) {
    return ResponseEntity.ok(memberService.update(id, member));
  }

  // Day 9 – Pagination
  @GetMapping("/page/{page}/{size}")
  public ResponseEntity<List<Member>> getMembersPaged(
      @PathVariable int page,
      @PathVariable int size) {
    return ResponseEntity.ok(memberService.getPaged(page, size));
  }
}

