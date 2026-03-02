package com.Security.demo.service;

import com.Security.demo.model.Food;
import com.Security.demo.repository.FoodRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    //Turning plain password to hashed password
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public FoodService(FoodRepository foodRepository, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.foodRepository = foodRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public Food register(Food food){
        food.setPassword(bCryptPasswordEncoder.encode(food.getPassword() ));
        return foodRepository.save(food);
    }

    public String verify(Food food){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(food.getFoodName(), food.getPassword()));

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(food.getFoodName());
        }else {
            return "Failure";
        }
    }
}
