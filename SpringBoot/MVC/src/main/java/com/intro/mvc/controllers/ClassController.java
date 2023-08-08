package com.intro.mvc.controllers;

import com.intro.mvc.Services.SchoolService;
import com.intro.mvc.dto.CriteriaDto;
import com.intro.mvc.dto.RequestDto;
import com.intro.mvc.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {
    private final SchoolService schService;

    @Autowired
    public ClassController(SchoolService schService){
        this.schService = schService;
    }

    @PostMapping("/specification")
    public ResponseEntity<List<Class>> getStudents(@RequestBody CriteriaDto criteriaDto){
        System.out.println("Call spec");
        List<Class> resp = schService.filterByCriteria(criteriaDto);
        if(!resp.isEmpty()){
            return new ResponseEntity<>(resp, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/specifications")
    public ResponseEntity<List<Class>> getStudents(@RequestBody RequestDto reqDto){
        List<Class> resp = schService.filterByMulCriterias(reqDto);
        if(!resp.isEmpty()){
            return new ResponseEntity<>(resp, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
