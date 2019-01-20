package com.cartelera.infocarteapi.repository;

import com.cartelera.infocarteapi.model.Billboard;
import com.cartelera.infocarteapi.model.Comment;
import com.cartelera.infocarteapi.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "comments", collectionResourceRel = "comments")
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
  List<Comment> findByContent(@Param("content") String content);
}