package com.delgadotw.myfirstwebapp.controllers;

import com.delgadotw.myfirstwebapp.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController
{
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService)
    {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public String getAllRestaurant(Model model){
        model.addAttribute("restaurant", restaurantService.getAllRestaurants());
                    // in this line "restaurant" is the name of the variable to use in html
        return "restaurant";
                    // in this other line restaurant is the name of template to render to.
    }
}
