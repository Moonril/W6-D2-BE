package it.epicode.W6_D2_BE.repository;

import it.epicode.W6_D2_BE.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
