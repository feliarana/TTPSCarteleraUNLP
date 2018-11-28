package com.cartelera.infocarteapi.model;

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
@Table(name = "user")
public class User extends BaseEntity {
  @Id
  @Column
  private Long id;

  @Column
  private String username;

  @Column
  private String password;

  @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
  private List<Role> roles;
  private boolean active;
}
