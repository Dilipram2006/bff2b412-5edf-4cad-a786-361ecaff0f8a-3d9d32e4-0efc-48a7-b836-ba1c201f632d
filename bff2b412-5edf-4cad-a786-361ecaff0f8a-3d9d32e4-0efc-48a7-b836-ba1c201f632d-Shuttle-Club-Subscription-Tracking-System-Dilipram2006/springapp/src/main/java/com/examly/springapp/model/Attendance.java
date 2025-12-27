package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Attendance {

  @Id
  @GeneratedValue
  private int id;

  public Attendance(int id) {
    this.id = id;
  }

  public Attendance() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}

