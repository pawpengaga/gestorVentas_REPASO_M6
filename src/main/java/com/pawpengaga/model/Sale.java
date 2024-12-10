package com.pawpengaga.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale {

  private long id;
  private long userId;
  private LocalDate fechaVenta;

}
