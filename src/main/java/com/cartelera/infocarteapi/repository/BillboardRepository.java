package com.cartelera.infocarteapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cartelera.infocarteapi.model.Billboard;

@RepositoryRestResource(path = "billboards", collectionResourceRel = "billboards")
public interface BillboardRepository extends PagingAndSortingRepository<Billboard, Long> {
}
