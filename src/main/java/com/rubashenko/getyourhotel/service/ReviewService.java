package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);
    List<Review> showAllReviews();
    void deleteReview(Long id);
}
