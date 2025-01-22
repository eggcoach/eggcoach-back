package eggcoach_project.eggcoach.service;

import eggcoach_project.eggcoach.domain.Category;
import eggcoach_project.eggcoach.domain.Post;
import eggcoach_project.eggcoach.dto.CommunityRequestDTO;
import eggcoach_project.eggcoach.dto.CommunityResponseDTO;
import eggcoach_project.eggcoach.repository.CategoryRepository;
import eggcoach_project.eggcoach.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Transactional
    public CommunityResponseDTO.PostDTO findPost(Integer postId) {

        Post post = postRepository.findPostById(postId).get();
        post.addViewCount();

        List<CommunityResponseDTO.CommentDTO> commentDTOList = post.getComments().stream()
                .map(comment -> CommunityResponseDTO.CommentDTO.builder()
                        .author(comment.getAuthor())
                        .content(comment.getContent())
                        .build())
                .toList();

        return CommunityResponseDTO.PostDTO.builder()
                .title(post.getTitle())
                .author(post.getAuthor())
                .content(post.getContent())
                .likes(post.getLikes())
                .view_counts(post.getView_count())
                .comment_counts(post.getComment_count())
                .comments(commentDTOList)
                .build();
    }

    @Transactional
    public void updatePost(Integer postId, CommunityRequestDTO.PostDTO postDTO) {

        Post post = postRepository.findById(postId).get();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
    }

    public void deletePost(Integer postId) {

        Post post = postRepository.findById(postId).get();
        postRepository.delete(post);
    }
}
