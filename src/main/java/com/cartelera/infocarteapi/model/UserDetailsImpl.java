package com.cartelera.infocarteapi.model;

import com.cartelera.infocarteapi.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl extends User implements UserDetails {

  public UserDetailsImpl(User user) {
    super();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getRoles()
      .stream()
      .map(role-> new SimpleGrantedAuthority("ROLE_"+role.getRoleName()))
      .collect(Collectors.toList());
  }

  @Override
  public Long getId() {
    return super.getId();
  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getUsername() {
    return super.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}