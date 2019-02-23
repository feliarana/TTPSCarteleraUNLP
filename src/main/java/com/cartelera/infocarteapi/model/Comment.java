package com.cartelera.infocarteapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @NotNull
  private String comment;

  public Comment(Long id, Post post, User user, String comment){
    this.setId(id);
    this.setPost(post);
    this.setUser(user);
    this.setComment(comment);
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date created_at;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date updated_at;

  @PrePersist
  protected void onCreate() {
    created_at = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updated_at = new Date();
  }

}
