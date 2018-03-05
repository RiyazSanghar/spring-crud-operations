package com.jpa.service;

import com.jpa.entity.CustomUserDetails;
import com.jpa.entity.User;
import com.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserDetailService implements UserDetailsService{



    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {

        Optional<User> userOptional = userRepository.findByEmail(email);

        userOptional
        .orElseThrow(()->new UsernameNotFoundException("Email Not Found"));

          return userOptional
                .map(CustomUserDetails::new).get();



    }

}
