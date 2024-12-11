package com.pawpengaga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawpengaga.model.Product;
import com.pawpengaga.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {

  @Autowired
  ProductService productService;

  @GetMapping
  public String listar(Model model){
    model.addAttribute("products", productService.getAllProducts());
    return "products/productos";
  }

  @GetMapping("/add")
  public String nuevo(Model model){
    model.addAttribute("product", new Product());
    return "products/formulario";
  }

  @PostMapping()
  public String graba(@ModelAttribute Product product){
    productService.createProduct(product);
    return "redirect:/products";
  }

}
