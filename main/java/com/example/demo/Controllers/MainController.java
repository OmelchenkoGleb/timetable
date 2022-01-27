package com.example.demo.Controllers;


import com.example.demo.Models.grouup;
import com.example.demo.Models.timetable;
import com.example.demo.reporm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class MainController {

    @Autowired
    timetableRepository timetableRepository;

    @Autowired
    grouupRepository grouupRepository;

    @Autowired
    listRepository listRepository;

    @Autowired
    studentsRepository studentsRepository;

    @Autowired
    dayRepository dayRepository;

    @GetMapping("/timetable")
    public String timetable(@RequestParam String name, @RequestParam String surname, @RequestParam String day, Model model) {
        try{
            if(!Objects.equals(day, "")) {
                List<timetable> timetables = timetableRepository.findAllByGrouupAndDay(listRepository.findByStudents(studentsRepository.findByNameAndSurname(name,surname)).getGrouup(), dayRepository.findByName(day));
                model.addAttribute("timetables",timetables);
                return "/timetable";
            }
            List<timetable> timetables = timetableRepository.findAllByGrouup(listRepository.findByStudents(studentsRepository.findByNameAndSurname(name,surname)).getGrouup());
            model.addAttribute("timetables",timetables);
            return "/timetable";
        } catch (Exception e){
            return "redirect:/";
        }
    }

    @GetMapping("/")
    public String home(Model model) {
        return "/main";
    }
    @GetMapping("/adminlogin")
    public String adminlogin(Model model) {
        return "/admin_login";
    }
}
