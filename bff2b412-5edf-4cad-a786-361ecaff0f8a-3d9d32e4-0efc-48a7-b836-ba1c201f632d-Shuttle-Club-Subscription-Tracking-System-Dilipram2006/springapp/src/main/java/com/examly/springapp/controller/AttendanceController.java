package com.examly.springapp.controller;

import com.examly.springapp.model.Attendance;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

  @GetMapping("/{id}")
  public Attendance getAttendance(@PathVariable int id) {
    return new Attendance();
  }
}

