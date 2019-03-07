package com.cartelera.infocarteapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Set<UserNotification> notifications;

  @ManyToOne
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

}
