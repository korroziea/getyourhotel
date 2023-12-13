package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.Review;
import com.rubashenko.getyourhotel.repository.ReviewRepository;
import com.rubashenko.getyourhotel.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;


    @Override
    public Review createReview(Review review) {
        review.setUser_id(9L);
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> showAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
