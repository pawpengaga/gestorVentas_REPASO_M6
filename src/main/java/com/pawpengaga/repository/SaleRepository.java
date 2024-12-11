package com.pawpengaga.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pawpengaga.model.Sale;

@Repository
public class SaleRepository {

  @Autowired
  JdbcTemplate jdbc;

  // Este sera distinto por el uso de clave foranea...

  public List<Sale> findAll(){
    String sql = "SELECT * FROM sales";
    return jdbc.query(sql, new BeanPropertyRowMapper<>(Sale.class)); // El equivalente al rowMapper al parecer...
  }

  public int save(Sale saleInput){
    String sql = "INSERT INTO sales (user_id, fecha_venta) VALUES (?, ?) RETURNING id"; // Devolvemos el id de la venta para usarla en el detalle
    return jdbc.update(sql, saleInput.getUserId(), saleInput.getFechaVenta());
  }

}
