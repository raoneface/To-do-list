package com.shubham.crudSpringBootDemo.Service;

import org.springframework.stereotype.Service;

import com.shubham.crudSpringBootDemo.Entity.Student;
import com.shubham.crudSpringBootDemo.Repository.StudentRepository;

@Service 
public class StudentService {
    
    private  StudentRepository studentRepository; 

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        Student createdStudent = studentRepository.saveStudent(studentReq);
        return createdStudent;
    }
}
