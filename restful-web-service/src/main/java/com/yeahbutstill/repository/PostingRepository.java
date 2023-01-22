package com.yeahbutstill.repository;

import com.yeahbutstill.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Long> {
}
