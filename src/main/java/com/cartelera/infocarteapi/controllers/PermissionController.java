package com.cartelera.infocarteapi.controllers;

import com.cartelera.infocarteapi.model.Billboard;
import com.cartelera.infocarteapi.model.Permission;
import com.cartelera.infocarteapi.model.User;
import com.cartelera.infocarteapi.repository.BillboardRepository;
import com.cartelera.infocarteapi.repository.PermissionRepository;
import com.cartelera.infocarteapi.repository.UserRepository;
import com.cartelera.infocarteapi.util.DataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Optional.empty;

@RestController
public class PermissionController {
  private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BillboardRepository billboardRepository;

  @Autowired
  private PermissionRepository permissionRepository;

  @DeleteMapping("/permission/billboard/{billboard_id}/user/{user_id}")
  public DataResponse deletePermission(@PathVariable Long user_id, @PathVariable Long billboard_id ) {

    Optional<User> user = userRepository.findById(user_id);
    Optional<Billboard> billboard = billboardRepository.findById(billboard_id);

    Optional<Permission> permission = permissionRepository.findByUserAndBillboard(billboard.get(), user.get());

    Boolean success = false;
    if (permission.isPresent()) {
      permissionRepository.deleteById(permission.get().getId());
      success = true;
    }
    DataResponse response = new DataResponse ();
    response.setSuccess(success);
    return response;
  }
}
