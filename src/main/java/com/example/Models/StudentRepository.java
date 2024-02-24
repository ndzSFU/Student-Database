package com.example.Models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Will automatically get turned into SQL
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
    Student findById(int id);
    List<Student> findByNameAndWeight(String name, int weight);
}
