package com.example.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String hairColour;
    private float gpa;
    private int weight;
    private int height;

    
    Student(){

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    // public Student(String name, int weight, float gpa, String Hcolour, int id){
    //     this.name = name;
    //     this.hairColour = Hcolour;
    //     this.gpa = gpa;
    //     this.weight = weight;
    //     this.id = id;
    // }

    public Student(String name, int weight, float gpa, String Hcolour, int height){
        this.name = name;
        this.hairColour = Hcolour;
        this.gpa = gpa;
        this.weight = weight;
        this.height = height;
    }
}
