package com.example.demo.Controllers;



import com.example.demo.DAO.RoomDao;
import com.example.demo.Models.room;
import com.example.demo.reporm.roomRepository;
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
public class RoomController {

    @Autowired
    roomRepository roomRepository;

    @Autowired
    RoomDao roomDao;

    @GetMapping("/room")
    public String home(Model model) {
        Iterable<room> rooms = roomRepository.findAll();
        model.addAttribute("rooms",rooms);
        return "/room/room";
    }


    @GetMapping("/room/add")
    public String Add(Model model) {
        return "/room/room_add";
    }


    @PostMapping("/room/ad")
    public String PostAdd(@RequestParam String number) {
        roomDao.save(number);
        return "redirect:/room";
    }


    @GetMapping("/room/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, Model model){
        if(!roomRepository.existsById(id)){
            return "redirect:/room";
        }
        Optional<room> room = roomRepository.findById(id);
        ArrayList<room> rooms = new ArrayList<>();
        room.ifPresent(rooms::add);
        model.addAttribute("rooms",rooms);
        return "/room/room_edit";
    }


    @PostMapping("/room/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, @RequestParam String number, Model model){
        int i = roomDao.Update(id,number);
        return "redirect:/room";
    }



    @GetMapping("/room/delite/{id}")
    public String Delite(@PathVariable(value = "id") Long id, Model model){
        roomRepository.deleteById(id);
        return "redirect:/room";
    }

    @GetMapping("/room/search")
    public String Search(@RequestParam String number, Model model){
        List<room> rooms = roomDao.Search(number);
        model.addAttribute("rooms",rooms);
        return "/room/room";
    }
}
