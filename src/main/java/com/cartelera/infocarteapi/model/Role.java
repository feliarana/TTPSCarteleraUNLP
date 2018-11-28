package com.cartelera.infocarteapi.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="role")
public class Role extends BaseEntity{

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "role_name")
  private String roleName;

}