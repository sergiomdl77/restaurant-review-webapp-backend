package com.delgadotw.myfirstwebapp.service;

import com.delgadotw.myfirstwebapp.data.RestaurantRepository;
import com.delgadotw.myfirstwebapp.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService
{
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants()
    {
        return restaurantRepository.findAll();
    }

}
