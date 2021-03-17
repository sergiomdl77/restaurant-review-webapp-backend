package com.delgadotw.myfirstwebapp.service;

import com.delgadotw.myfirstwebapp.data.ReviewRepository;
import com.delgadotw.myfirstwebapp.models.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService
{
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository)
    {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews()
    {
        return reviewRepository.findAll();
    }

}