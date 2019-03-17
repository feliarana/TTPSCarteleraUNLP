package com.cartelera.infocarteapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "billboards")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") //esto es para que no entre en loop infinito en algunos json responses
public class Billboard {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String title;

  @Column(length = 500)
  private String description;

  private String image;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date created_at;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date updated_at;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User created_by;

  @OneToMany(mappedBy = "billboard")
  private List<Post> posts = new ArrayList<Post>();

  @OneToMany(mappedBy = "billboard")
  private List<Permission> permissions = new ArrayList<Permission>();

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
    name = "followed_billboards",
    joinColumns = {@JoinColumn(name = "billboard_id")},
    inverseJoinColumns = {@JoinColumn(name = "user_id")}
  )
  private List<User> usersFollowers = new ArrayList<User>();

  @PrePersist
  protected void onCreate() {
    created_at = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updated_at = new Date();
  }


}
