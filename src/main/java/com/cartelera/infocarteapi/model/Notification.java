package com.cartelera.infocarteapi.model;

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

  public String text;


  @OneToMany(mappedBy="user")
  private Set<UserNotification> notifications;


}
