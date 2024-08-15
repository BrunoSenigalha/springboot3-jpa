package com.brunoSenigalha.course.repositories;

import com.brunoSenigalha.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
