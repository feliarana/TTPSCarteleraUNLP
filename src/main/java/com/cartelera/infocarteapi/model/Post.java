package com.cartelera.infocarteapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name = "posts")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id") //esto es para que no entre en loop infinito en algunos json responses
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @NotNull
  private String title;

  @Column
  private String image;

  @Column(length = 255)
  private String description;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date created_at;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date updated_at;

  @Column
  private Boolean comments_enabled;

  @PrePersist
  protected void onCreate() {
    created_at = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updated_at = new Date();
  }

  @ManyToOne
  @JoinColumn(name="billboard_id", nullable=false)
  private Billboard billboard;

  @ManyToOne
  @JoinColumn(name="user_id", nullable=false)
  private User user;

  @OneToMany(mappedBy = "post")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private List<Comment> comments = new ArrayList<Comment>();

  @OneToMany(mappedBy = "post")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private List<Notification> notifications = new ArrayList<>();

}
