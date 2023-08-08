package com.intro.mvc.controllers;


import com.intro.mvc.Services.SchoolService;
import com.intro.mvc.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class StudentController {
    private final SchoolService schService;

    @Autowired
    public StudentController(SchoolService schService){
        this.schService = schService;
    }
    @GetMapping
    public ResponseEntity<List<Student>> getStudentByCriteria(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) int minAge,
            @RequestParam(required = false) int maxAge
    ){
        Specification<Student> spec = Specification.where(null);
        List<Student> resp = schService.filterByCriteria(name,gender,minAge,maxAge,spec);
        if(!resp.isEmpty()){
            return new ResponseEntity<>(resp, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
