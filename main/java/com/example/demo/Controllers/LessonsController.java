package com.example.demo.Controllers;

import com.example.demo.DAO.LessonsDao;
import com.example.demo.Models.lessons;
import com.example.demo.reporm.lessonsRepository;
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
public class LessonsController {

    @Autowired
    lessonsRepository lessonsRepository;

    @Autowired
    LessonsDao lessonsDao;

    @GetMapping("/lessons")
    public String home(Model model) {
        Iterable<lessons> lesson = lessonsRepository.findAll();
        model.addAttribute("lessons",lesson);
        return "/lessons/lessons";
    }


    @GetMapping("/lessons/add")
    public String Add(Model model) {
        return "/lessons/lessons_add";
    }


    @PostMapping("/lessons/ad")
    public String PostAdd(@RequestParam String name) {
        if(lessonsRepository.findByName(name) != null) return "redirect:/lessons";
        lessonsDao.save(name);
        return "redirect:/lessons";
    }


    @GetMapping("/lessons/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, Model model){
        if(!lessonsRepository.existsById(id)){
            return "redirect:/lessons";
        }
        Optional<lessons> lesson = lessonsRepository.findById(id);
        ArrayList<lessons> lessons = new ArrayList<>();
        lesson.ifPresent(lessons::add);
        model.addAttribute("lessons",lessons);
        return "/lessons/lessons_edit";
    }



    @PostMapping("/lessons/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, @RequestParam String name, Model model){
        lessons lessons1 = lessonsRepository.findByName(name);
        if(lessons1 != null) return "redirect:/lessons";
        int i = lessonsDao.Update(id,name);
        return "redirect:/lessons";
    }



    @GetMapping("/lessons/delite/{id}")
    public String Delite(@PathVariable(value = "id") Long id, Model model){
        lessonsRepository.deleteById(id);
        return "redirect:/lessons";
    }

    @GetMapping("/lessons/search")
    public String Search(@RequestParam String name, Model model){
        List<lessons> lessons = lessonsDao.Search(name);
        model.addAttribute("lessons",lessons);
        return "/lessons/lessons";
    }
}
