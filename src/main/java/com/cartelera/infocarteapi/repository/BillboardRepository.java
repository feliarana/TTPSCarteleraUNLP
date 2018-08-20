package com.cartelera.infocarteapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cartelera.infocarteapi.entities.Billboard;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "billboards", collectionResourceRel = "billboards")
public interface BillboardRepository extends PagingAndSortingRepository<Billboard, Long> {
  List<Billboard> findByTitle(@Param("title") String title);
}
