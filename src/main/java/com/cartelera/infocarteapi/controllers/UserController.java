package com.cartelera.infocarteapi.controllers;

import com.cartelera.infocarteapi.model.*;
import com.cartelera.infocarteapi.payload.UserIdentityAvailability;
import com.cartelera.infocarteapi.payload.UserSummary;
import com.cartelera.infocarteapi.repository.BillboardRepository;
import com.cartelera.infocarteapi.repository.CommentRepository;
import com.cartelera.infocarteapi.repository.UserNotificationRepository;
import com.cartelera.infocarteapi.repository.UserRepository;
import com.cartelera.infocarteapi.security.CurrentUser;
import com.cartelera.infocarteapi.security.UserPrincipal;
import com.cartelera.infocarteapi.util.DataResponse;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BillboardRepository billboardRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private UserNotificationRepository userNotificationRepository;

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @GetMapping("/users/me")
//  @PreAuthorize("hasRole('ROLE_USER')")
  public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
    UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getAuthorities());
    return userSummary;
  }

  @GetMapping("/users/check_username_availability")
  public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
    Boolean isAvailable = !userRepository.existsByUsername(username);
    return new UserIdentityAvailability(isAvailable);
  }

  @GetMapping("/users/{id}/comments")
  @CrossOrigin(origins = "*")
  public DataResponse comments(@PathVariable Long id) {
    List<Comment> comments = commentRepository.findAllByUserId(id);
    DataResponse response = new DataResponse ();
    response.setSuccess(true);
    response.setCount(comments.size());
    response.setData(comments);
    return response;
  }

  @PostMapping("/users/{id}/followBillboard")
  @CrossOrigin(origins = "*")
  public DataResponse followBillboard(@RequestBody Map<String, Object> payload, @PathVariable Long id ) {

    Optional<User> user = userRepository.findById(id);
    List<Billboard> followedBillboards =  user.get().getFollowedBillboards();

    Optional<Billboard> billboard = billboardRepository.findById(Long.valueOf((String) payload.get("billboard_id")));

    Boolean success;
    if (!followedBillboards.contains(billboard.get())){
      followedBillboards.add(billboard.get());
      user.get().setFollowedBillboards(followedBillboards);
      userRepository.save(user.get());
      success = true;
    }
    else{
      success = false;
    }
    DataResponse response = new DataResponse ();
    response.setSuccess(success);
    return response;
  }


  @GetMapping("/users/{user_id}/unfollowBillboard/{billboard_id}")
  @CrossOrigin(origins = "*")
  public DataResponse unfollowBillboard(@PathVariable Long user_id, @PathVariable Long billboard_id ) {

    Optional<User> user = userRepository.findById(user_id);
    List<Billboard> followedBillboards =  user.get().getFollowedBillboards();

    Optional<Billboard> billboard = billboardRepository.findById(billboard_id);

    Boolean success;
    if (followedBillboards.contains(billboard.get())){
      followedBillboards.remove(billboard.get());
      user.get().setFollowedBillboards(followedBillboards);
      userRepository.save(user.get());
      success = true;
    }
    else{
      success = false;
    }
    DataResponse response = new DataResponse ();
    response.setSuccess(success);
    return response;
  }

  @GetMapping("/users/{user_id}/userNotifications/{userNotificationId}")
  @CrossOrigin(origins = "*")
  public DataResponse comments(@PathVariable Long user_id, @PathVariable Long userNotificationId) {
    Optional<User> user = userRepository.findById(user_id);
    Optional<UserNotification> optionalUserNotification = userNotificationRepository.findById(userNotificationId);
    UserNotification userNotification = optionalUserNotification.get();
    userNotification.setRead(true);
    userNotificationRepository.save(userNotification);
    DataResponse response = new DataResponse ();
    response.setSuccess(true);
    return response;
  }

}
