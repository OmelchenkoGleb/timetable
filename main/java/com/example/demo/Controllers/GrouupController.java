package com.example.demo.Controllers;


import com.example.demo.DAO.GrouupDao;
import com.example.demo.Models.grouup;
import com.example.demo.reporm.grouupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class GrouupController {

    @Autowired
    grouupRepository grouupRepository;

    @Autowired
    GrouupDao grouupDao;

    @GetMapping("/grouup")
    public String home(Model model) {
        Iterable<grouup> grouups = grouupRepository.findAll();
        model.addAttribute("grouups",grouups);
        return "/grouup/grouup";
    }


    @GetMapping("/grouup/add")
    public String Add(Model model) {
        return "/grouup/grouup_add";
    }


    @PostMapping("/grouup/ad")
    public String PostAdd(@RequestParam String name) {
        if(grouupRepository.findAllByName(name) != null) return "redirect:/grouup";
        grouupDao.save(name);
        return "redirect:/grouup";
    }


    @GetMapping("/grouup/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, Model model){
        if(!grouupRepository.existsById(id)){
            return "redirect:/grouup";
        }
        Optional<grouup> grouup = grouupRepository.findById(id);
        ArrayList<grouup> grouups = new ArrayList<>();
        grouup.ifPresent(grouups::add);
        model.addAttribute("grouups",grouups);
        return "/grouup/grouup_edit";
    }



    @PostMapping("/grouup/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, @RequestParam String name, Model model){
        grouup grouup1 = grouupRepository.findAllByName(name);
        if(grouup1 != null) return "redirect:/grouup";
        int i = grouupDao.Update(id,name);
        return "redirect:/grouup";
    }



    @GetMapping("/grouup/delite/{id}")
    public String Delite(@PathVariable(value = "id") Long id, Model model){
        grouupRepository.deleteById(id);
        return "redirect:/grouup";
    }

    @GetMapping("/grouup/search")
    public String Search(@RequestParam String name, Model model){
        List<grouup> grouups = grouupDao.Search(name);
        model.addAttribute("grouups",grouups);
        return "/grouup/grouup";
    }
}
