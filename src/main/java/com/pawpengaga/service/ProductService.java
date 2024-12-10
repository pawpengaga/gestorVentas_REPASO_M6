package com.pawpengaga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawpengaga.model.Product;
import com.pawpengaga.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  ProductRepository prodRepo;

  public List<Product> getAllProducts(){
    return prodRepo.findAll();
  }

  public int createProduct(Product productInput){
    return prodRepo.save(productInput);
  }

}
