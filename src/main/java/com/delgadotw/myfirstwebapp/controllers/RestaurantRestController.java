package com.delgadotw.myfirstwebapp.controllers;

import com.delgadotw.myfirstwebapp.models.Restaurant;
import com.delgadotw.myfirstwebapp.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantRestController
{
    private final RestaurantService restaurantService;

    public RestaurantRestController(RestaurantService restaurantService)
    {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Restaurant>> getAllRestaurants()
    {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") long id)
    {
        Restaurant restaurant = restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant)
    {
        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant)
    {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.CREATED);
    }

    // This method won't return the restaurant that was deleted
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable("id") long id)
    {
        restaurantService.deleteRestaurantById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
