package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Membership {

  @Id
  @GeneratedValue
  private int id;

  public Membership(int id) {
    this.id = id;
  }

  public Membership() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}

