package com.examly.springapp.service;

import com.examly.springapp.model.Attendance;
import java.util.List;

public interface AttendanceService {
  Attendance saveAttendance(Attendance attendance);
  List<Attendance> getAllAttendance();
}

