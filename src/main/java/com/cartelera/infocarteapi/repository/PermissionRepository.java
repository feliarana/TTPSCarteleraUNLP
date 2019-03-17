package com.cartelera.infocarteapi.repository;

import com.cartelera.infocarteapi.model.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {
}
