package com.Security.demo.service;


import com.Security.demo.model.UserPrincipalS;
import com.Security.demo.repository.FoodRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//creating custom verification of username and password and  overriding the default verification
@Service
public class MyUserDetailsServiceS implements UserDetailsService {


    private final FoodRepository foodRepository;

    public MyUserDetailsServiceS(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String foodName) throws UsernameNotFoundException {

        return foodRepository.findByFoodName(foodName)
                .map(UserPrincipalS::new)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Food not found with name: " + foodName
                        )
                );
    }
}
