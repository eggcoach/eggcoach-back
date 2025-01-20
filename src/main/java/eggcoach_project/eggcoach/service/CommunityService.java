package eggcoach_project.eggcoach.service;

import eggcoach_project.eggcoach.domain.Category;
import eggcoach_project.eggcoach.domain.Post;
import eggcoach_project.eggcoach.dto.CommunityRequestDTO;
import eggcoach_project.eggcoach.repository.CategoryRepository;
import eggcoach_project.eggcoach.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    public void savePost(Integer categoryId, CommunityRequestDTO.PostDTO postDTO) {

        Category category = categoryRepository.findById(categoryId).get();
        Post post = Post.builder()
                .title(postDTO.getTitle())
                .author(postDTO.getAuthor())
                .content(postDTO.getContent())
                .category(category)
                .build();

        postRepository.save(post);
    }
}
