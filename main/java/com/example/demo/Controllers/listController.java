package com.example.demo.Controllers;

import com.example.demo.DAO.TimetableDao;
import com.example.demo.DAO.listsDao;
import com.example.demo.Models.list;
import com.example.demo.Models.timetable;
import com.example.demo.reporm.*;
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
public class listController {
    @Autowired
    listRepository listRepository;
    @Autowired
    dayRepository dayRepository;
    @Autowired
    grouupRepository grouupRepository;
    @Autowired
    studentsRepository studentsRepository;
    @Autowired
    listsDao listsDao;



    @GetMapping("/list")
    public String home(Model model) {
        Iterable<list> lists = listRepository.findAll();
        model.addAttribute("lists",lists);
        return "/list/list";
    }


    @GetMapping("/list/search")
    public String Search(@RequestParam String surname, @RequestParam String grouupname, Model model){
        List<list> lists;
        if(!grouupname.equals("") && surname.equals("")) {
            lists = listRepository.findAllByGrouup(grouupRepository.findAllByName(grouupname));
        } else if (!surname.equals("") && grouupname.equals("")){
            lists = listRepository.findAllByStudents(studentsRepository.findBySurname(surname));
        } else {
            lists = listRepository.findAllByGrouupAndStudents(grouupRepository.findAllByName(grouupname), studentsRepository.findBySurname(surname));
        }
        model.addAttribute("lists",lists);
        return "/list/list";
    }


    @GetMapping("/list/delite/{id}")
    public String Delite(@PathVariable(value = "id") Long id, Model model){
        listRepository.deleteById(id);
        return "redirect:/list";
    }


    @GetMapping("/list/add")
    public String Add(Model model) {
        return "/list/list_add";
    }


    @PostMapping("/list/ad")
    public String PostAdd(@RequestParam String namegrouup ,@RequestParam String name ,@RequestParam String surname) {
        try {
            listsDao.save(namegrouup, name, surname);
            return "redirect:/list";
        } catch (Exception e) {
            return "redirect:/list";
        }
    }


    @GetMapping("/list/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, Model model){
        if(!listRepository.existsById(id)){
            return "redirect:/list";
        }
        Optional<list> list = listRepository.findById(id);
        ArrayList<list> lists = new ArrayList<>();
        list.ifPresent(lists::add);
        model.addAttribute("lists",lists);
        return "/list/list_edit";
    }


    @PostMapping("/list/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, @RequestParam String namegrouup ,@RequestParam String name ,@RequestParam String surname, Model model){
        try{
            int i = listsDao.Update(id,namegrouup, name, surname);
            return "redirect:/list";
        } catch (Exception e){
            return "redirect:/list";
        }
    }
}
