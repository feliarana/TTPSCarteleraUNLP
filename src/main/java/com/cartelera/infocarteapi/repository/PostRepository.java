package com.cartelera.infocarteapi.repository;

import com.cartelera.infocarteapi.model.Billboard;
import com.cartelera.infocarteapi.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "posts", collectionResourceRel = "posts")
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
  List<Billboard> findByTitle(@Param("title") String title);
}
