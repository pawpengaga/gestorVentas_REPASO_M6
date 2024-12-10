package com.pawpengaga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleDetail {

  private long id;
  private long saleId;
  private long productId;
  private int cantidad;
  private double subtotal;

}
