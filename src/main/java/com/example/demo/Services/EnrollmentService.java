package com.example.demo.Services;

import org.springframework.stereotype.Service;
import studentmanagement.models.Student;
import studentmanagement.models.Course;
import studentmanagement.models.Enrollment;

import java.util.*;

@Service
public class EnrollmentService {
    private final List<Enrollment> enrollments = new ArrayList<>();
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Course> courses = new HashMap<>();

    public String addStudent(Student student) {
        student.setStudentID(UUID.randomUUID().toString());
        students.put(student.getStudentID(), student);
        return "Étudiant ajouté : " + student.getName();
    }

    public String addCourse(Course course) {
        course.setCourseCode(UUID.randomUUID().toString());
        courses.put(course.getCourseCode(), course);
        return "Cours ajouté : " + course.getCourseName();
    }

    public String enrollStudent(String studentID, String courseCode) {
        Student student = students.get(studentID);
        Course course = courses.get(courseCode);

        if (student == null) return "Étudiant non trouvé.";
        if (course == null) return "Cours non trouvé.";

        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
        return student.getName() + " inscrit dans " + course.getCourseName();
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }
}
