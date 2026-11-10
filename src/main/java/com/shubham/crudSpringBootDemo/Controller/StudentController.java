package com.shubham.crudSpringBootDemo.Controller;

//import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.crudSpringBootDemo.Entity.Student;
import com.shubham.crudSpringBootDemo.Service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // create a api -> save()

    // create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        // return ResponseEntity.ok(createdStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        // return ResponseEntity.status(201).body(createdStudent);
    }

    // read
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student recieveStudent = studentService.getStudent(id);
        if(recieveStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recieveStudent);
    }

    
     // get all
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getStudent() {
        List<Student> receiveStudent = studentService.getAllStudent();
        if(receiveStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(receiveStudent);
    }

    // update
    @PutMapping("/update/{id}") 
    public ResponseEntity<Student> updateStudent(@PathVariable Long id , @RequestBody Student studentReq){
         Student studentResp  = studentService.updateStudent(id , studentReq);
        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);

    }
    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isdeleted = studentService.deleteStudent(id);
        if(!isdeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok("record deleted");
    }

}
