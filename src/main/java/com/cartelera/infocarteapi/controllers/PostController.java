package com.cartelera.infocarteapi.controllers;

import com.cartelera.infocarteapi.repository.BillboardRepository;
import com.cartelera.infocarteapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/api/billboards")
public class PostController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BillboardRepository billboardRepositoryRepository;


  private static final Logger logger = LoggerFactory.getLogger(PostController.class);

//    @GetMapping
//    public PagedResponse<PollResponse> getPolls(@CurrentUser UserPrincipal currentUser,
//                                                @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
//                                                @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
//        return pollService.getAllPolls(currentUser, page, size);
//    }
//
//    @PostMapping
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<?> createPoll(@Valid @RequestBody PollRequest pollRequest) {
//        Poll poll = pollService.createPoll(pollRequest);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{pollId}")
//                .buildAndExpand(poll.getId()).toUri();
//
//        return ResponseEntity.created(location)
//                .body(new ApiResponse(true, "Poll Created Successfully"));
//    }
//
//
//    @GetMapping("/{pollId}")
//    public PollResponse getPollById(@CurrentUser UserPrincipal currentUser,
//                                    @PathVariable Long pollId) {
//        return pollService.getPollById(pollId, currentUser);
//    }
//
//    @PostMapping("/{pollId}/votes")
//    @PreAuthorize("hasRole('USER')")
//    public PollResponse castVote(@CurrentUser UserPrincipal currentUser,
//                         @PathVariable Long pollId,
//                         @Valid @RequestBody VoteRequest voteRequest) {
//        return pollService.castVoteAndGetUpdatedPoll(pollId, voteRequest, currentUser);
//    }

}
