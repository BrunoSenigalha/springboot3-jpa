package com.brunoSenigalha.course.repositories;

import com.brunoSenigalha.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
