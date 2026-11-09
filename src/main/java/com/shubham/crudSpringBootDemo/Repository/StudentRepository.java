package com.shubham.crudSpringBootDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shubham.crudSpringBootDemo.Entity.Student;

//@Repository

//we can write @Repository but it not affect anything bceause it is interface
public interface StudentRepository extends JpaRepository<Student,Long> {

}
