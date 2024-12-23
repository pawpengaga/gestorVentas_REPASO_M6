package com.pawpengaga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase para generar usuarios
 * @author Erick Rivera
 */
@AllArgsConstructor // Constructor completo
@NoArgsConstructor // Constructor sin argumentos
@Data // Getters, setters y toString
public class User {

  private long id;
  private String nombre;
  private String correo;

}
