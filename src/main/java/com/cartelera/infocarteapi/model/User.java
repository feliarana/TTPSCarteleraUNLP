package com.cartelera.infocarteapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@Entity
//@Table(name = "user")
//@Inheritance(strategy = InheritanceType.JOINED)
public class User {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue
  private int id;
//  private String username;
//  private String password;
//  private String email;
//  private int phone;//en caso que tenga wsp se utilizara esta infomacion

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
