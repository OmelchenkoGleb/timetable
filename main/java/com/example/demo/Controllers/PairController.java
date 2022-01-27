package com.example.demo.Controllers;



import com.example.demo.DAO.PairDao;
import com.example.demo.Models.pair;
import com.example.demo.reporm.pairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PairController {

    @Autowired
    pairRepository pairRepository;

    @Autowired
    PairDao pairDao;

    @GetMapping("/pair")
    public String home(Model model) {
        Iterable<pair> pairs = pairRepository.findAll();
        model.addAttribute("pairs",pairs);
        return "/pair/pair";
    }

    @GetMapping("/pair/add")
    public String Add(Model model) {
        return "/pair/pair_add";
    }


    @PostMapping("/pair/ad")
    public String PostAdd(@RequestParam String number, @RequestParam String start, @RequestParam String finish) {
        pairDao.save(number, start, finish);
        return "redirect:/pair";
    }

    @GetMapping("/pair/delite/{id}")
    public String Delite(@PathVariable(value = "id") Long id, Model model){
        pairRepository.deleteById(id);
        return "redirect:/pair";
    }


    @GetMapping("/pair/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, Model model){
        if(!pairRepository.existsById(id)){
            return "redirect:/pair";
        }
        Optional<pair> pair = pairRepository.findById(id);
        ArrayList<pair> pairs = new ArrayList<>();
        pair.ifPresent(pairs::add);
        model.addAttribute("pairs",pairs);
        return "/pair/pair_edit";
    }



    @PostMapping("/pair/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, @RequestParam String number, @RequestParam String start, @RequestParam String finish, Model model){
        int i = pairDao.Update(id,number,start,finish);
        return "redirect:/pair";
    }

}
