package com.jpa.controller;


import com.jpa.entity.JwtUser;
import com.jpa.security.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    @Autowired
    private  JwtTokenGenerator jwtTokenGenerator;


    public TokenController(JwtTokenGenerator jwtTokenGenerator) {
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public String generateToken(@RequestBody JwtUser jwtUser)
    {
        return jwtTokenGenerator.generate(jwtUser);
    }
}
