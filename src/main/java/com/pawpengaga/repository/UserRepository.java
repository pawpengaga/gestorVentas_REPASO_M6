package com.pawpengaga.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pawpengaga.model.User;

@Repository
public class UserRepository {

  @Autowired
  JdbcTemplate jdbc;

  
  // private final RowMapper<User> rowMapper (rs, rowNum);
  
  // EXPERIMENTAL. SIN USO DE ROWMAPPER GLOBAL
  public List<User> findAll(){
    String sql = "SELECT * FROM users";
    return jdbc.query(sql, (rs, rowNum) -> 
      new User(
        rs.getLong("id"),
        rs.getString("nombre"),
        rs.getString("correo")
      )
    );
  }

  public int save(User userInput){
    String sql = "INSERT INTO users (nombre, correo) VALUES (?,?)";
    return jdbc.update(sql, userInput.getNombre(), userInput.getCorreo());
  }
  
}
