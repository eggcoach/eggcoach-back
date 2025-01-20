package eggcoach_project.eggcoach.repository;

import eggcoach_project.eggcoach.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
