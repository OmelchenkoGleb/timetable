package com.example.demo.Controllers;


import com.example.demo.DAO.DayDao;
import com.example.demo.Models.day;
import com.example.demo.reporm.dayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class DayController {

    @Autowired
    dayRepository dayRepository;

    @Autowired
    DayDao dayDao;

    @GetMapping("/day")
    public String home(Model model) {
        Iterable<day> days = dayRepository.findAll();
        model.addAttribute("days",days);
        return "/day/day";
    }

    @GetMapping("/day/add")
    public String Add(Model model) {
        return "/day/day_add";
    }


    @PostMapping("/day/ad")
    public String PostAdd(@ModelAttribute day day) {
        if(dayRepository.findByName(day.getName()) != null) return "redirect:/day";
        dayRepository.save(day);
        return "redirect:/day";
    }

    @GetMapping("/day/delite/{id}")
    public String Delite(@PathVariable(value = "id") Long id, Model model){
        dayRepository.deleteById(id);
        return "redirect:/day";
    }


    @GetMapping("/day/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, Model model){
        if(!dayRepository.existsById(id)){
            return "redirect:/day";
        }
        Optional<day> day = dayRepository.findById(id);
        ArrayList<day> days = new ArrayList<>();
        day.ifPresent(days::add);
        model.addAttribute("days",days);
        return "/day/day_edit";
    }



    @PostMapping("/day/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, @RequestParam String name, Model model){
        day day1 = dayRepository.findByName(name);
        if(day1 != null) return "redirect:/admin";
        int i = dayDao.Update(id,name);
        return "redirect:/day";
    }
}
