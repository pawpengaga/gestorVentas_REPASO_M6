package com.pawpengaga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawpengaga.model.Sale;
import com.pawpengaga.repository.SaleRepository;

@Service
public class SaleService {

  @Autowired
  SaleRepository saleRepo;

  public List<Sale> getAllSales(){
    return saleRepo.findAll();
  }

  public int createSale(Sale saleInput){
    return saleRepo.save(saleInput);
  }

}
