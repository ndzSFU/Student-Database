package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Models.Student;
import com.example.Models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping(value = {"/", "/home"})
    public String showAll() {
        return "redirect:/students/view";
    }


    @GetMapping("/students/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all Users!");
        //gets all users from database
        List<Student> students = studentRepo.findAll();
       
        //end of database call
        model.addAttribute("Us", students);
        return "students/showAll";  //This jumps to a new folder (showAll)
    }

    @GetMapping("/students/add")
    public String goToAddStudent() {
        //Goes to the html
        return "students/add";
    }

    // then the html takes us here
    @PostMapping("/students/add")
    public String addStudent(@RequestParam Map<String, String> newStudent, HttpServletResponse response) {
        System.out.println("ADD student");
        String newName = newStudent.get("name");
        int newWeight = Integer.parseInt(newStudent.get("weight"));
        float newGpa = Float.parseFloat(newStudent.get("gpa"));
        String newHairColour = newStudent.get("hairColour");
        int newHeight = Integer.parseInt(newStudent.get("height"));

        studentRepo.save(new Student(newName,newWeight,newGpa,newHairColour, newHeight));
        response.setStatus(201);
        return "redirect:/students/view";
    }

    @GetMapping("/students/delete")
    public String goToDeleteStudent(Model model) {
        List<Student> students = studentRepo.findAll();
        model.addAttribute("Us", students);
        return "students/delete";
    }



    @PostMapping("/students/delete")
    public String deleteStudent(@RequestParam("studentId") int studentId) {
        studentRepo.deleteById(studentId);
        // Redirect back to the main page 
        return "redirect:/students/view";
    }

    @GetMapping("/students/change")
    public String goToChangeStudent(Model model) {
        List<Student> students = studentRepo.findAll();
        model.addAttribute("Us", students);
        return "students/changeList";
    }

    @GetMapping("/students/modify")
    public String goToChangeStudentSpecifics(Model model, @RequestParam("studentId") int studentId) {
        Student studentToChange = studentRepo.findById(studentId);
        model.addAttribute("Us", List.of(studentToChange));
        return "students/changeStudent";
    }


    @PostMapping("/students/change")
    public String changeStudent(@RequestParam Map<String, String> newStudent, @RequestParam("studentId") int studentId) {
        Student oldStudent = studentRepo.findById(studentId);

        String newName = newStudent.get("name");
        int newWeight = Integer.parseInt(newStudent.get("weight"));
        float newGpa = Float.parseFloat(newStudent.get("gpa"));
        String newHairColour = newStudent.get("hairColour");
        int newHeight = Integer.parseInt(newStudent.get("height"));

        oldStudent.setGpa(newGpa);
        oldStudent.setHairColour(newHairColour);
        oldStudent.setName(newName);
        oldStudent.setWeight(newWeight);
        oldStudent.setHeight(newHeight);

        studentRepo.save(oldStudent);
      
        return "redirect:/students/view";
    }
}
