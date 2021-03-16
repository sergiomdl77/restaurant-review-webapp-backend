package com.delgadotw.myfirstwebapp.service;

import com.delgadotw.myfirstwebapp.data.RestaurantRepository;
import com.delgadotw.myfirstwebapp.models.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
