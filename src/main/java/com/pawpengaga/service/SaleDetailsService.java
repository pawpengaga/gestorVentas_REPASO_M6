package com.pawpengaga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawpengaga.model.SaleDetail;
import com.pawpengaga.repository.SaleDetailRepository;

@Service
public class SaleDetailsService {

  @Autowired
  SaleDetailRepository sdRepo;

  public List<SaleDetail> getAllDetails(){
    return sdRepo.findAll();
  }

  public int createSaleDetail(SaleDetail sdInput){
    return sdRepo.save(sdInput);
  }

}
