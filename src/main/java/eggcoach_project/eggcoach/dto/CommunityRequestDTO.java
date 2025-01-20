package eggcoach_project.eggcoach.dto;

import lombok.Getter;

public class CommunityRequestDTO {

    @Getter
    public static class PostDTO {

        private String title;
        private String author;
        private String content;
    }
}
