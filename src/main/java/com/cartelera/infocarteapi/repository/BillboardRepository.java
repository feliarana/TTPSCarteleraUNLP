package com.cartelera.infocarteapi.repository;

import com.cartelera.infocarteapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cartelera.infocarteapi.model.Billboard;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "billboards", collectionResourceRel = "billboards")
public interface BillboardRepository extends JpaRepository<Billboard,Long> {
//  List<Billboard> findByTitle(@Param("title") String title);
}
