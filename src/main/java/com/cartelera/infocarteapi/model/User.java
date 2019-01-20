package com.cartelera.infocarteapi.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String username;

  @Column
  private String password;

  @Column
  private boolean active;

  private Date created_at;

  private Date updated_at;

  @ManyToMany(cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
  })
  @JoinTable(
    name = "users_roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
  )
  private Set<Role> roles;

  @OneToMany(mappedBy = "created_by")
  private List<Billboard> createdBillboard = new ArrayList<Billboard>();

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "followed_billboards",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "billboard_id") }
  )
  private List<Billboard> followedBillboards = new ArrayList<Billboard>();

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
    name = "liked_billboards",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "billboard_id") }
  )
  private List<Billboard> likedBillboards = new ArrayList<Billboard>();


  @PrePersist
  protected void onCreate() {
    created_at = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updated_at = new Date();
  }


  public <T> User(String username, String password, Set<Role> roles, boolean active) {
    this.username = username;
    this.password = password;
    this.roles = roles;
    this.active = active;
  }
}
