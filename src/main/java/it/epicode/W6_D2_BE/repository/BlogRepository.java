package it.epicode.W6_D2_BE.repository;

import it.epicode.W6_D2_BE.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
