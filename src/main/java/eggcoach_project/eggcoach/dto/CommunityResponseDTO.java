package eggcoach_project.eggcoach.dto;

import eggcoach_project.eggcoach.domain.Comment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class CommunityResponseDTO {

    @Builder
    @Getter
    public static class PostDTO {

        private String title;
        private String author;
        private String content;
        private Integer likes;
        private Integer view_counts;
        private Integer comment_counts;
        private List<CommentDTO> comments;
    }

    @Builder
    @Getter
    public static class CommentDTO {

        private String author;
        private String content;
    }
}
