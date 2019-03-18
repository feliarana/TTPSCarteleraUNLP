package com.cartelera.infocarteapi.repository;

import com.cartelera.infocarteapi.model.Billboard;
import com.cartelera.infocarteapi.model.Permission;
import com.cartelera.infocarteapi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {
  @Query("SELECT p " +
    "FROM Permission p where p.billboard = :billboard and p.user = :user")
  Optional<Permission> findByUserAndBillboard(@Param("billboard")Billboard billboard, @Param("user") User user);

}
