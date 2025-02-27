package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import studentmanagement.services.EnrollmentService;
import studentmanagement.models.Student;
import studentmanagement.models.Course;
import studentmanagement.models.Enrollment;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return enrollmentService.addStudent(student);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return enrollmentService.addCourse(course);
    }

    @PostMapping
    public Enrollment enrollStudent(@RequestParam String studentID, @RequestParam String courseCode) {
        return enrollmentService.enrollStudent(studentID, courseCode);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
}
