package com.delgadotw.myfirstwebapp.service;

import com.delgadotw.myfirstwebapp.data.ReviewRepository;
import com.delgadotw.myfirstwebapp.exception.ReviewNotFoundException;
import com.delgadotw.myfirstwebapp.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReviewService
{
    private final ReviewRepository reviewRepository;

    @Autowired       //  Annotation used for the ReviewRepository dependency injection into our ReviewService.
    // not necessary when there is only one constructor, but still a good practice to be explicit
    public ReviewService(ReviewRepository reviewRepository)
    {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews()
    {
        return reviewRepository.findAll();
    }

    public void deleteReviewById(long rvId)
    {
        reviewRepository.deleteById(rvId);
    }

    public Review addReview(Review review)
    {
        return reviewRepository.saveAndFlush(review);
    }

    public Review updateReview(Review review)
    {
       return reviewRepository.save(review);
    }

    public Review findReviewById(long id)
    {
        return reviewRepository.findById(id).orElseThrow(
                () -> new ReviewNotFoundException("Review by id " + id + " was not found."));
    }
}