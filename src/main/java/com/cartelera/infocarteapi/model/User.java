package com.cartelera.infocarteapi.model;

import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


//@Data
//@Builder
//@NoArgsConstructor

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {
  @UniqueConstraint(columnNames = {
    "username"
  }),
})
public class User {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id", unique = true, nullable = false)
//  private Long id;
//
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String username;

  @Column
  private String password;

  @ManyToMany(cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
  })
  @JoinTable(
    name = "users_roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
  )
  private Collections<Role> roles = new HashSet<>();

  @Column
  private boolean active;

  public <T> User(String username, String password, Set<T> roles, boolean active) {
    this.username = username;
    this.password = password;
    this.roles = roles;
    this.active = active;
  }
}
