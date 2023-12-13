package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
