package com.cartelera.infocarteapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "notifications")
public class Notification {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String text;

  @OneToMany(mappedBy="notification")
  private Set<UserNotification> notifications;

  @ManyToOne
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

}
