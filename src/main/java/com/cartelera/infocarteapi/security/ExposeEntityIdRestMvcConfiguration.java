package com.cartelera.infocarteapi.security;

import com.cartelera.infocarteapi.model.Billboard;
import com.cartelera.infocarteapi.model.Comment;
import com.cartelera.infocarteapi.model.Post;
import com.cartelera.infocarteapi.model.User;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class ExposeEntityIdRestMvcConfiguration extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Billboard.class);
    config.exposeIdsFor(Post.class);
    config.exposeIdsFor(Comment.class);
    config.exposeIdsFor(User.class);
  }
}