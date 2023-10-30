package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getAllStudent() {
    return studentService.getAllStudent();
  }

  @GetMapping("/{studentId}")
  public Student getStudentInfo(@PathVariable int studentId) {
    return studentService.getStudentInfo(studentId);
  }

  @DeleteMapping("/{studentId}")
  public String removeStudent(@PathVariable int studentId) {
    return studentService.removeStudent(studentId);
  }

  @PostMapping
  public String addStudent(@RequestBody Student student) {
    return studentService.addStudent(student);
  }
  @PutMapping("/{studentId}")
  public String updateStudent(@PathVariable int studentId, @RequestBody StudentDTO studentDTO) {
    return studentService.updateStudent(studentId, studentDTO);
  }
}
