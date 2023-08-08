package com.intro.mvc.Services;

import com.intro.mvc.dto.CriteriaDto;
import com.intro.mvc.dto.RequestDto;
import com.intro.mvc.model.Class;
import com.intro.mvc.model.Student;

import com.intro.mvc.repositories.ClassRepository;
import com.intro.mvc.repositories.StudentRepository;
import com.intro.mvc.specifications.ClassSpecification;
import com.intro.mvc.specifications.StudentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private final StudentRepository studentRepo;
    private final ClassRepository classRepo;

    @Autowired
    public SchoolService(StudentRepository studentRepo, ClassRepository classRepo){
        this.studentRepo = studentRepo;
        this.classRepo = classRepo;
    }


    public Optional<Student> getStudent(int id){
        return studentRepo.findById(id);
    }

    public Optional<Class> getClass(int id){
        return classRepo.findById(id);
    }
    public Student addStudent(Student s){
        return studentRepo.save(s);
    }

    public Class addClass(Class c){
        return classRepo.save(c);
    }

    public boolean removeStudent(int id){
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean removeClass(int id){
        if(classRepo.existsById(id)){
            classRepo.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Student> getAllStudents(){
        List<Student> stRecords = new ArrayList<>();
        studentRepo.findAll().forEach(stRecords::add);
        return stRecords;
    }

    public boolean updateRecord(Student s){
        if(studentRepo.existsById(s.getId())){
            studentRepo.save(s);
            return true;
        }
        return false;
    }

    public List<Class> getClassByCapacity(int capacity){
        return classRepo.findClassesByCapacity(capacity);
    }

    public List<Student> getStudentsByGender(String gender){
        return studentRepo.findByGender(gender);
    }

    public List<Student> filterByCriteria(String name, String gender,int minAge,int maxAge, Specification<Student> spec){
        if(name!=null){
            spec=spec.and(StudentSpecification.hasName(name));
        }
        if(gender!=null){
            spec=spec.and(StudentSpecification.hasGender(gender));
        }
        if(minAge>0){
            spec=spec.and(StudentSpecification.hasGreaterThan(minAge));
        }
        if(maxAge>0){
            spec=spec.and(StudentSpecification.hasLesserThan(minAge));
        }

        return studentRepo.findAll(spec);
    }

    public List<Class> filterByCriteria(CriteriaDto criteriaDto){
        System.out.println("serve call");
        Specification<Class> spec = ClassSpecification.applySpecification(criteriaDto);
        return classRepo.findAll(spec);
    }
    public List<Class> filterByMulCriterias(RequestDto rDto){
        Specification<Class> spec = ClassSpecification.applySpecification(rDto.getCriteriaDtoList(),rDto.getBoolOp());
        return classRepo.findAll(spec);
    }
}
