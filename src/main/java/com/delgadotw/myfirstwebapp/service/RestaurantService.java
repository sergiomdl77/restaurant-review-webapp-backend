package com.delgadotw.myfirstwebapp.service;

import com.delgadotw.myfirstwebapp.data.RestaurantRepository;
import com.delgadotw.myfirstwebapp.exception.MemberNotFoundException;
import com.delgadotw.myfirstwebapp.exception.RestaurantNotFoundException;
import com.delgadotw.myfirstwebapp.models.Member;
import com.delgadotw.myfirstwebapp.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RestaurantService
{
    private final RestaurantRepository restaurantRepository;

    @Autowired       //  Annotation used for the RestaurantRepository dependency injection into our RestaurantService.
    // not necessary when there is only one constructor, but still a good practice to be explicit
    public RestaurantService(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants()
    {
        return restaurantRepository.findAll();
    }

    public void deleteRestaurantById(long rsId)
    {
        restaurantRepository.deleteById(rsId);
    }

    public Restaurant addRestaurant(Restaurant restaurant)
    {
        return restaurantRepository.saveAndFlush(restaurant);
    }

    public Restaurant updateRestaurant(Restaurant restaurant)
    {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant findRestaurantById(long id)
    {
        return restaurantRepository.findById(id).orElseThrow(
                () -> new RestaurantNotFoundException("Restaurant by id " + id + " was not found."));
    }
}
