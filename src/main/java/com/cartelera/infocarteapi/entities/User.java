package com.cartelera.infocarteapi.entities;

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
//@Table(name = "user")
//@Inheritance(strategy = InheritanceType.JOINED)
public class User {
  @Id
  @GeneratedValue
  private long id;
  private String username;
  private String password;
  private String email;
  private int phone;
//  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  private List<Role> roles;

// ;//en caso que tenga wsp se utilizara esta infomacion

//  @OneToMany(mappedBy = "post")//un usuario tiene muchas publicaciones
//  private List<Post> publicaciones;
//
//  @OneToMany(mappedBy = "billboard")//un usuario crea muchas carteleras
//  private List<Billboard> carteleras;
//
//  @OneToMany(mappedBy = "comment")
//  private List<Comment> comentarios;
//
//  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
////un usuario tiene uno y solo un tipo de notificacion(facebook,wsp,...)
//  @JoinColumn(name = "notification")
//  private Notification notification;

//    @OneToOne
//    private Template configuracion;//cada  admin va a tener una configuracion

}
