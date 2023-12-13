package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.Review;
import com.rubashenko.getyourhotel.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/hotel")
@RequiredArgsConstructor
public class ReviewResource {
    private final ReviewService reviewService;

    @GetMapping("/{hotel_id}/review/new")
    public String newReview(@ModelAttribute("review") Review review) {
        return "review/new";
    }

    @PostMapping("/{hotel_id}/review/create")
    public String saveReview(@PathVariable("hotel_id") Long hotel_id, @ModelAttribute("review") Review review) {
        review.setHotel_id(hotel_id);
        reviewService.createReview(review);
        return "redirect:/hotel/review/showAll";
    }

    @GetMapping("/{hotel_id}/review")
    public String showReviews(Model model) {
        List<Review> reviews = reviewService.showAllReviews();
        model.addAttribute("reviews", reviews);
        return "review/showAll";
    }
}
