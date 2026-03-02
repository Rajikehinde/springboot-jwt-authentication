package com.Security.demo.controller;

import com.Security.demo.model.Food;
import com.Security.demo.service.FoodService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class foodController {

    private final FoodService foodService;

    public foodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/register")
    public Food register(@RequestBody Food food){
        return foodService.register(food);
    }

    @PostMapping("/login")
    public String login(@RequestBody Food food){
        return foodService.verify(food);
    }
}
