package com.delgadotw.myfirstwebapp.data;

import com.delgadotw.myfirstwebapp.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>
{

}