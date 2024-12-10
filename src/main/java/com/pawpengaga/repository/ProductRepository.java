package com.pawpengaga.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pawpengaga.model.Product;

@Repository
public class ProductRepository {

  @Autowired
  JdbcTemplate jdbc;

  // Hecho nuevamente con el rowMap dentro
  public List<Product> findAll(){
    String sql = "SELECT * FROM products";
    return jdbc.query(sql, (rs, rowNum) -> 
      new Product(
        rs.getLong("id"),
        rs.getString("nombre"),
        rs.getDouble("precio")
      )
    );
  }

  public int save(Product productInput){
    String sql = "INSERT INTO products (nombre, precio) VALUES (?,?)";
    return jdbc.update(sql, productInput.getNombre(), productInput.getPrecio());
  }

}
