package com.shubham.crudSpringBootDemo.Repository;

import org.springframework.stereotype.Repository;

import com.shubham.crudSpringBootDemo.Entity.Student;

@Repository
public class StudentRepository  {

    public Student saveStudent(Student studentReq) {
        // save to datadb
        Student s1 = new Student();
        s1.setName("Shubham");
        s1.setEmail("Raoneface@gmail.com");
        s1.setAge(27);
        s1.setSubject("CSE");
        Long l1 = (long)1321;
        s1.setId(l1);
        return s1;
    }
}
