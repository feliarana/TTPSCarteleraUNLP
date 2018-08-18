package com.cartelera.infocarteapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
//@Table(name = "user")
//@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {
  private String username;
  private String password;
  @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
  private List<Role> roles;
  private boolean active;
}
