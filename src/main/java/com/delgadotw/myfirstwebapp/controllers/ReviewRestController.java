package com.delgadotw.myfirstwebapp.controllers;

import com.delgadotw.myfirstwebapp.models.Review;
import com.delgadotw.myfirstwebapp.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
   Class that makes the connection between the client and the endpoint.
   It is in charge of mapping the client's requests to the appropriate
   web services to expose the data from the Database and then send the
   appropriate response back to the client as a Response Entity. If
   there is any data that needs to be sent back in the Response Entity
   it will have the data (Review object or list of Review objects)
   packaged in JSON format as the body of the response.

   All of the methods in this class will be accessed by an Http Request
   that contains the base URL for this app plus the "/api/review" path.
   Whatever is left in the path will indicate this class which of this
   methods/handlers will handle the http request.

   NOTE: In the case of the Review objects received in the body of the
   HTTP Requests handled in this Rest Controller, it is IMPORTANT to mention
   that even though they come with no id property, the creation of the new
   Review object for the use of Spring Boot in this back end is created
   by injection of the Review object in the Heading of the method declaration.
   This injection makes Spring Boot call the constructor with parameters in the
   class Review, which in turn will generate the Id field. This means that
   by the time the code inside the method is executed the Review object has
   been assigned a brand new Id code.
 */

@RestController
@RequestMapping("/api/review")
public class ReviewRestController
{
    private final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService)
    {
        this.reviewService = reviewService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Review>> getAllReviews()
    {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") long id)
    {
        Review review = reviewService.findReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review)
    {
        Review newReview = reviewService.addReview(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Review> updateReview(@RequestBody Review review)
    {
        Review updatedReview = reviewService.updateReview(review);
        return new ResponseEntity<>(updatedReview, HttpStatus.CREATED);
    }

    // This method won't return the review that was deleted
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable("id") long id)
    {
        reviewService.deleteReviewById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }}