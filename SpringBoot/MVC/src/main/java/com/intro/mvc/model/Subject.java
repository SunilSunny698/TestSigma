package com.intro.mvc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;




@Entity(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student studentId;

}
