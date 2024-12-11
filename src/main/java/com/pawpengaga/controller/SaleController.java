package com.pawpengaga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawpengaga.model.Product;
import com.pawpengaga.model.Sale;
import com.pawpengaga.repository.ProductRepository;
import com.pawpengaga.repository.SaleDetailRepository;
import com.pawpengaga.repository.SaleRepository;
import com.pawpengaga.repository.UserRepository;
@Controller
@RequestMapping("/sales")
public class SaleController {

  // Hacemos una carga de toda la informacion para el formulario

  @Autowired
  SaleRepository saleRepo;

  @Autowired
  UserRepository userRepo;

  @Autowired
  ProductRepository productRepo;

  @Autowired
  SaleDetailRepository sdRepo;

  @GetMapping("/listar")
  public String listar(Model model){
    model.addAttribute("sales", saleRepo.findAll());
    return "sales/sales"; // ??
  }

  @GetMapping
  public String nuevo(Model model){
    model.addAttribute("users", userRepo.findAll());
    model.addAttribute("products", productRepo.findAll());
    model.addAttribute("sale", new Sale());
    return "sales/sales";
  }

  @PostMapping()
  public String graba(@ModelAttribute Sale salesInput){
    saleRepo.save(salesInput);
    return "redirect:/sales";
  }

}
