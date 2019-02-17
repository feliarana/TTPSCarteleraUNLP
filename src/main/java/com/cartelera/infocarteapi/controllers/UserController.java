package com.cartelera.infocarteapi.controllers;

import com.cartelera.infocarteapi.model.Comment;
import com.cartelera.infocarteapi.payload.UserIdentityAvailability;
import com.cartelera.infocarteapi.payload.UserSummary;
import com.cartelera.infocarteapi.repository.CommentRepository;
import com.cartelera.infocarteapi.repository.UserRepository;
import com.cartelera.infocarteapi.security.CurrentUser;
import com.cartelera.infocarteapi.security.UserPrincipal;
import com.cartelera.infocarteapi.util.DataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CommentRepository commentRepository;

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
//    HashMap<String, Long> map = new HashMap<>();
//
//    for (int i = 0; i < comments.size(); i++) {
//      map.put("comment_id", ((Comment) comments.get(i)).getId());
//    }
    DataResponse response = new DataResponse ();
    response.setSuccess(true);
    response.setCount(comments.size());
    response.setData(comments);
    return response;
  }


}
