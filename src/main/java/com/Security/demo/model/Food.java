package com.Security.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class Food {

    @Id
     private int id;

     private String foodName;

     private String foodType;

     private String password;
}
