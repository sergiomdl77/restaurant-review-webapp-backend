package com.delgadotw.myfirstwebapp.controllers;

import com.delgadotw.myfirstwebapp.models.Restaurant;
import com.delgadotw.myfirstwebapp.service.RestaurantService;
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
   it will have the data (Restaurant object or list of Restaurant objects)
   packaged in JSON format as the body of the response.

   All of the methods in this class will be accessed by an Http Request
   that contains the base URL for this app plus the "/api/restaurant" path.
   Whatever is left in the path will indicate this class which of this
   methods/handlers will handle the http request.

   NOTE: In the case of the Restaurant objects received in the body of the
   HTTP Requests handled in this Rest Controller, it is IMPORTANT to mention
   that even though they come with no id property, the creation of the new
   Restaurant object for the use of Spring Boot in this back end is created
   by injection of the Restaurant object in the Heading of the method declaration.
   This injection makes Spring Boot call the constructor with parameters in the
   class Restaurant, which in turn will generate the Id field. This means that
   by the time the code inside the method is executed the Restaurant object has
   been assigned a brand new Id code.
 */

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
