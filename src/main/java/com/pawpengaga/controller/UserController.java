package com.pawpengaga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawpengaga.model.User;
import com.pawpengaga.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserRepository userRepo;

  @GetMapping // El @GetMapping vacio lleva al @GetMapping padre
  public String listar(Model model){
    model.addAttribute("users", userRepo.findAll());
    return "users/usuarios"; // Este es el nombre del archivo html
  }

  @GetMapping("/add")
  public String nuevo(Model model){
    model.addAttribute("user", new User());
    return "users/formulario";
  }

  @PostMapping()
  public String graba(@ModelAttribute User user){
    userRepo.save(user);
    return "redirect:/users";
  }

}
