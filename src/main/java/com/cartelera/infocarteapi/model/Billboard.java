package com.cartelera.infocarteapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "billboards")
public class Billboard {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  private String title;

  private String description;

  private String image;

  private Date created_at;

  private Date updated_at;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User created_by;

  @OneToMany(mappedBy = "billboard")
  private List<Post> posts = new ArrayList<Post>();

  @PrePersist
  protected void onCreate() {
    created_at = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updated_at = new Date();
  }


}
