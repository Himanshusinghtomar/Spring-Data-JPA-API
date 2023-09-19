package com.example.springdatajpa.binding;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer cid;
    @JsonProperty
    private  String name;
    @JsonProperty
    private  Double price;

}

