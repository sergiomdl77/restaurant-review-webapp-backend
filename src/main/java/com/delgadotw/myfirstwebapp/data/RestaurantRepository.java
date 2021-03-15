package com.delgadotw.myfirstwebapp.data;

import com.delgadotw.myfirstwebapp.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>
{

}
