package com.jpa.service;

import com.jpa.entity.CustomUserDetails;
import com.jpa.entity.Users;
import com.jpa.repository.UsersRepository;
import org.hibernate.service.UnknownServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService{


    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Users> usersOptional = usersRepository.findByUserName(username);

        usersOptional
                .orElseThrow(()->new UsernameNotFoundException("User Name Not Found"));

        return usersOptional
                .map(CustomUserDetails::new)
                .get();

    }


}
