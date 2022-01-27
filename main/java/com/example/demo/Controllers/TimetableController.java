package com.example.demo.Controllers;

import com.example.demo.DAO.TimetableDao;
import com.example.demo.Models.timetable;
import com.example.demo.reporm.dayRepository;
import com.example.demo.reporm.grouupRepository;
import com.example.demo.reporm.timetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class TimetableController {
    @Autowired
    timetableRepository timetableRepository;
    @Autowired
    dayRepository dayRepository;
    @Autowired
    grouupRepository grouupRepository;
    @Autowired
    TimetableDao timetableDao;
    @GetMapping("/timetablee")
    public String home(Model model) {
        Iterable<timetable> timetables = timetableRepository.findAll();
        model.addAttribute("timetables",timetables);
        return "/timetable/timetable";
    }
    @GetMapping("/timetable/search")
    public String Search(@RequestParam String namegrouup, @RequestParam String nameday, Model model){
        List<timetable> timetables;
        if(!namegrouup.equals("") && nameday.equals("")) {
            timetables = timetableRepository.findAllByGrouup(grouupRepository.findAllByName(namegrouup));
        } else if (!nameday.equals("") && namegrouup.equals("")){
            timetables = timetableRepository.findAllByDay(dayRepository.findByName(nameday));
        } else {
            timetables = timetableRepository.findAllByGrouupAndDay(grouupRepository.findAllByName(namegrouup), dayRepository.findByName(nameday));
        }
        model.addAttribute("timetables",timetables);
        return "/timetable/timetable";
    }
    @GetMapping("/timetable/delite/{id}")
    public String Delite(@PathVariable(value = "id") Long id, Model model){
        timetableRepository.deleteById(id);
        return "redirect:/timetablee";
    }
    @GetMapping("/timetable/add")
    public String Add(Model model) {
        return "/timetable/timetable_add";
    }
    @PostMapping("/timetable/ad")
    public String PostAdd(@RequestParam String namegrouup ,@RequestParam String nameday ,@RequestParam String pairnumber ,@RequestParam String roomnumber ,@RequestParam String namelessons) {
        try {
            timetableDao.save(namegrouup, nameday, pairnumber, roomnumber, namelessons);
            return "redirect:/timetablee";
        } catch (Exception e) {
            return "redirect:/timetablee";
        }
    }
    @GetMapping("/timetable/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, Model model){
        if(!timetableRepository.existsById(id)){
            return "redirect:/timetablee";
        }
        Optional<timetable> timetable = timetableRepository.findById(id);
        ArrayList<timetable> timetables = new ArrayList<>();
        timetable.ifPresent(timetables::add);
        model.addAttribute("timetables",timetables);
        return "/timetable/timetable_edit";
    }
    @PostMapping("/timetable/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, @RequestParam String namegrouup ,@RequestParam String nameday ,@RequestParam String pairnumber ,@RequestParam String roomnumber ,@RequestParam String namelessons, Model model){
        try{
            int i = timetableDao.Update(id,namegrouup, nameday, pairnumber, roomnumber, namelessons);
            return "redirect:/timetablee";
        } catch (Exception e){
            return "redirect:/timetablee";
        }
    }
}
