package com.examly.springapp.controller;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.repository.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController {

  @Autowired
  private MembershipTypeRepository membershipTypeRepository;

  // CREATE Membership Type
  @PostMapping
  public ResponseEntity<MembershipType> createMembershipType(
      @RequestBody MembershipType membershipType) {

    MembershipType saved = membershipTypeRepository.save(membershipType);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }

  // UPDATE Membership Type
  @PutMapping("/{id}")
  public ResponseEntity<MembershipType> updateMembershipType(
      @PathVariable int id,
      @RequestBody MembershipType membershipType) {

    membershipType.setTypeId(id);
    MembershipType updated = membershipTypeRepository.save(membershipType);
    return ResponseEntity.ok(updated);
  }

  // GET ALL Membership Types
  @GetMapping
  public ResponseEntity<List<MembershipType>> getAllMembershipTypes() {
    return ResponseEntity.ok(membershipTypeRepository.findAll());
  }

  // GET Membership Types BY NAME
  @GetMapping("/name/{name}")
  public ResponseEntity<?> getMembershipTypesByName(
      @PathVariable String name) {

    List<MembershipType> list =
        membershipTypeRepository.findByTypeName(name);

    if (list == null || list.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NO_CONTENT)
          .body("No membership types found");
    }
    return ResponseEntity.ok(list);
  }

  // GET Membership Types BY PRICE RANGE
  @GetMapping("/price")
  public ResponseEntity<List<MembershipType>> getMembershipTypesByPriceRange(
      @RequestParam double min,
      @RequestParam double max) {

    return ResponseEntity.ok(
        membershipTypeRepository.findByPriceRange(min, max)
    );
  }
  
    // GET Membership Types BY PRICE LESS THAN
  @GetMapping("/price-less/{price}")
  public ResponseEntity<?> getMembershipTypesByPriceLessThan(
      @PathVariable double price) {

    List<MembershipType> list =
        membershipTypeRepository.findByPriceLessThan(price);

    if (list == null || list.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NO_CONTENT)
          .body("No membership types found");
    }
    return ResponseEntity.ok(list);
  }

  // GET Membership Types BY DURATION GREATER THAN
  @GetMapping("/duration-greater/{duration}")
  public ResponseEntity<?> getMembershipTypesByDurationGreaterThan(
      @PathVariable int duration) {

    List<MembershipType> list =
        membershipTypeRepository
            .findByDurationInMonthsGreaterThan(duration);

    if (list == null || list.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NO_CONTENT)
          .body("No membership types found with duration greater than " + duration);
    }
    return ResponseEntity.ok(list);
  }

  // GET Membership Type BY ID (PLACED LAST – NO CONFLICT)
  @GetMapping("/{id}")
  public ResponseEntity<MembershipType> getMembershipTypeById(
      @PathVariable int id) {

    return ResponseEntity.ok(
        membershipTypeRepository.findById(id).orElse(null)
    );
  }
}




 



