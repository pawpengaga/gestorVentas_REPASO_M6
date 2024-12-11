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
import com.pawpengaga.service.SaleService;

@Controller
@RequestMapping("/sales")
public class SaleController {

  @Autowired
  SaleService saleService;

  @GetMapping
  public String listar(Model model){
    model.addAttribute("sales", saleService.getAllSales());
    return "sales/sales"; // ??
  }

  @GetMapping("/add")
  public String nuevo(Model model){
    model.addAttribute("sale", new Product());
    return "sales/formulario";
  }

  @PostMapping()
  public String graba(@ModelAttribute Sale salesInput){
    saleService.createSale(salesInput);
    return "redirect:/sales";
  }

}
