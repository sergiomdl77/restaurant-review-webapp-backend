package com.delgadotw.myfirstwebapp.controllers;


import com.delgadotw.myfirstwebapp.models.Review;
import com.delgadotw.myfirstwebapp.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewRestController
{
    private final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
}