package eggcoach_project.eggcoach.controller;

import eggcoach_project.eggcoach.dto.CommunityRequestDTO;
import eggcoach_project.eggcoach.dto.CommunityResponseDTO;
import eggcoach_project.eggcoach.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/community/{communityId}/posts")
public class CommunityController {

    private final CommunityService communityService;

    @PostMapping
    public void createPost(@PathVariable Integer communityId, @RequestBody CommunityRequestDTO.PostDTO postDTO) {

        communityService.savePost(communityId, postDTO);
    }

    @GetMapping("/{postId}")
    public CommunityResponseDTO.PostDTO getPost(@PathVariable Integer communityId, @PathVariable Integer postId) {

        return communityService.findPost(postId);
    }
}
