package com.example.demo.Controllers;

import com.example.demo.DAO.AdminDao;
import com.example.demo.Models.admin;
import com.example.demo.reporm.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {


    @Autowired
    adminRepository adminRepository;
    @Autowired
    AdminDao adminDao;

    @GetMapping("/admin")
    public String home(Model model) {
        Iterable<admin> admins = adminRepository.findAll();
        model.addAttribute("admins",admins);
        return "/admin/admin";
    }


    @GetMapping("/admin/add")
    public String Add(Model model) {
        return "/admin/admin_add";
    }

//@ModelAttribute admin admin

    @PostMapping("/admin/ad")
    public String PostAdd(@RequestParam String username, @RequestParam String password) {
        admin admin = new admin(username,password);
        if(adminRepository.findByUsername(admin.getUsername()) != null) return "redirect:/admin";
        adminDao.save(admin);
        return "redirect:/admin";
    }



    @GetMapping("/admin/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, Model model){
        if(!adminRepository.existsById(id)){
            return "redirect:/admin";
        }
        Optional<admin> admin = adminRepository.findById(id);
        ArrayList<admin> admins = new ArrayList<>();
        admin.ifPresent(admins::add);
        model.addAttribute("admins",admins);
        return "/admin/admin_edit";
    }



    @PostMapping("/admin/edit/{id}")
    public String Edit(@PathVariable(value = "id") Long id, @RequestParam String login, @RequestParam String pass, Model model){
        admin admin1 = adminRepository.findByUsername(login);
        if(admin1 != null) return "redirect:/admin";
        int i = adminDao.Update(id,login,pass);
        return "redirect:/admin";
    }



    @GetMapping("/admin/delite/{id}")
    public String Delite(@PathVariable(value = "id") Long id, Model model){
        adminRepository.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/search")
    public String Search(@RequestParam String login, Model model){
        List<admin> admins = adminDao.Search(login);
        model.addAttribute("admins",admins);
        return "/admin/admin";
    }
}
