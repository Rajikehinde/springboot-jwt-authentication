package com.Security.demo.model;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

//Current user who is trying access or login
//this class is the bridge between the database user (Food) and Spring Security.
// Spring Security does not understand the Food entity directly,
// so you wrap it inside a UserDetails implementation (UserPrinciple).
public record UserPrincipalS(Food food) implements UserDetails {


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("FOOD"));
    }

    @Override
    public @Nullable String getPassword() {
        return food.getPassword();
    }

    @Override
    public String getUsername() {
        return food.getFoodName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
