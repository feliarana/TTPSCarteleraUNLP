package com.cartelera.infocarteapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Billboard extends BaseEntity{
  @NotNull
  private String title;
}
