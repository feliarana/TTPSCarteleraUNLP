package com.cartelera.infocarteapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class Billboard {
  @Id
  @GeneratedValue
  private long id;

  @NotNull
  private String title;
}
