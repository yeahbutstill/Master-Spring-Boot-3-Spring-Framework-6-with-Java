package com.yeahbutstill.repository;

import com.yeahbutstill.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
