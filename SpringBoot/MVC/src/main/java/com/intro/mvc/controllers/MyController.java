package com.intro.mvc.controllers;

import com.intro.mvc.Services.SchoolService;
import com.intro.mvc.model.Class;
import com.intro.mvc.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    private final SchoolService schService;

    @Autowired
    public MyController(SchoolService schService){
        this.schService = schService;
    }
    @PostMapping("/create")
    public ResponseEntity<Student> addStudent(@RequestBody Student s){
        System.out.println("Create call");
        Student added = schService.addStudent(s);
        if(added!=null){
            return new ResponseEntity<>(added, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable int id){
        System.out.println("get call");
        Optional<Student> retrived = schService.getStudent(id);
        System.out.println(retrived.isPresent());
        if(retrived.isPresent()) {
            System.out.println("Hello");
            return new ResponseEntity<>(retrived, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(retrived,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        System.out.println("Del call");
        boolean status = schService.removeStudent(id);
        if(status){
            return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Student>> getAll(){
        System.out.println("get all call");
        List<Student> allRecords= schService.getAllStudents();
        if(!allRecords.isEmpty()){
            return new ResponseEntity<>(allRecords,HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update")
    public ResponseEntity<String> updateRecord(@RequestBody Student s){
        System.out.println("Del call");
        boolean status = schService.updateRecord(s);
        if(status){
            return new ResponseEntity<>("Updated",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("capacity/{capacity}")
    public ResponseEntity<List<Class>> getAllClassesByCapcity(@PathVariable int capacity){
        List<Class> resp = schService.getClassByCapacity(capacity);
        if(!resp.isEmpty()){
            return new ResponseEntity<>(resp,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("gender/{gender}")
    public ResponseEntity<List<Student>> getAllStudentsByGender(@PathVariable String gender){
        List<Student> resp = schService.getStudentsByGender(gender);
        if(!resp.isEmpty()){
            return new ResponseEntity<>(resp,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
