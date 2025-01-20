package eggcoach_project.eggcoach.repository;

import eggcoach_project.eggcoach.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
