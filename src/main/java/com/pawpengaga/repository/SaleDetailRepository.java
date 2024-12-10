package com.pawpengaga.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pawpengaga.model.SaleDetail;

@Repository
public class SaleDetailRepository {

  @Autowired
  JdbcTemplate jdbc;

  // Aqui hay incluso mas relaciones foraneas...

  public List<SaleDetail> findAll(){
    String sql = "SELECT * FROM sale_details";
    return jdbc.query(sql, new BeanPropertyRowMapper<>(SaleDetail.class));
  }

  public int save(SaleDetail sdInput){
    String sql = "INSERT INTO sale_details (sale_id, product_id, cantidad, subtotal) VALUES (?,?,?,?)";
    return jdbc.update(sql,
      sdInput.getSaleId(),
      sdInput.getProductId(),
      sdInput.getCantidad(),
      sdInput.getSubtotal()
    );
  }

}
