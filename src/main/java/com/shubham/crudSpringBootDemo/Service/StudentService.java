package com.shubham.crudSpringBootDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shubham.crudSpringBootDemo.Entity.Student;
import com.shubham.crudSpringBootDemo.Repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // this will save the studentReq in database
    public Student createStudent(Student studentReq) {
        // save - create and update
        Student createdStudent = studentRepository.save(studentReq);
        return createdStudent;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResponse = studentRepository.findById(id);

        if (studentResponse.isPresent()) {
            return studentResponse.get();
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> studentResponse = studentRepository.findAll();

        if (!studentResponse.isEmpty()) {
            return studentResponse;
        }
        return null;
    }
}
