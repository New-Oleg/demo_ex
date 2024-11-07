package com.example.ultrademo.object;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="zai")
public class order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String worcer;

    private LocalDate dayStart;

    private String oborudovanie;
    private String typeProblem;
    private String description;
    private String user;

    private String status;

}