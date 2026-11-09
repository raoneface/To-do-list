package com.shubham.crudSpringBootDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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

    // logic for geting student
    public Student getStudent(Long id) {
        Optional<Student> studentResponse = studentRepository.findById(id);

        if (studentResponse.isPresent()) {
            return studentResponse.get();
        }
        return null;
    }

    // logic for getting for all student
    public List<Student> getAllStudent() {
        List<Student> studentResponse = studentRepository.findAll();

        if (!studentResponse.isEmpty()) {
            return studentResponse;
        }
        return null;
    }

    // logic for update
    public Student updateStudent(Long id , Student studentReq) {
        Optional<Student> ExistingStudent = studentRepository.findById(id);
        if(ExistingStudent.isEmpty()){
            return null;
        }else{
            Student studentTosave = ExistingStudent.get();
            studentTosave.setName(studentReq.getName());
            studentTosave.setEmail(studentReq.getEmail());
            studentTosave.setAge(studentReq.getAge());
            studentTosave.setSubject(studentReq.getSubject());
            return studentRepository.save(studentTosave);
        }
    }
}
