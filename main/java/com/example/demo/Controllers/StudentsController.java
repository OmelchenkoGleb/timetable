package com.example.demo.Controllers;

import com.example.demo.DAO.StudentsDao;
import com.example.demo.Models.students;
import com.example.demo.reporm.studentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentsController {

    @Autowired
    studentsRepository studentsRepository;

    @Autowired
    StudentsDao studentsDao;


    @GetMapping("/students")
    public String home(Model model) {
        Iterable<students> students = studentsRepository.findAll();
        model.addAttribute("students",students);
        return "/students/students";
    }


    @GetMapping("/students/add")
    public String Add(Model model) {
        return "/students/students_add";
    }


    @PostMapping("/students/ad")
    public String PostAdd(@RequestParam String name, @RequestParam String surname) {
        studentsDao.save(name, surname);
        return "redirect:/students";
    }


    @GetMapping("/students/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, Model model){
        if(!studentsRepository.existsById(id)){
            return "redirect:/students";
        }
        Optional<students> student = studentsRepository.findById(id);
        ArrayList<students> students = new ArrayList<>();
        student.ifPresent(students::add);
        model.addAttribute("students",students);
        return "/students/students_edit";
    }

    @PostMapping("/students/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, @RequestParam String name, @RequestParam String surname, Model model){
        int i = studentsDao.Update(id,name, surname);
        return "redirect:/students";
    }



    @GetMapping("/students/delite/{id}")
    public String Delite(@PathVariable(value = "id") Long id, Model model){
        studentsRepository.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/search")
    public String Search(@RequestParam String surname, Model model){
        List<students> students = studentsDao.Search(surname);
        model.addAttribute("students",students);
        return "/students/students";
    }
}
