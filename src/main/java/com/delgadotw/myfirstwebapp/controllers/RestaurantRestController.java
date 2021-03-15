package com.delgadotw.myfirstwebapp.controllers;

import com.delgadotw.myfirstwebapp.models.Restaurant;
import com.delgadotw.myfirstwebapp.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantRestController
{
    private final RestaurantService restaurantService;

    public RestaurantRestController(RestaurantService restaurantService)
    {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }
}
