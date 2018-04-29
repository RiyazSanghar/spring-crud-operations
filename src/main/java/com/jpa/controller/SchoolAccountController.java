package com.jpa.controller;


import com.jpa.entity.School;
import com.jpa.service.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Rest Controller to Perform School Related Operations")
public class SchoolAccountController {

@Autowired
    SchoolService schoolService;



    @ApiOperation(value = "Get All the Schools")
    @RequestMapping(value = "/school", method = RequestMethod.GET)
    public String getAllSchools()
    {

        return "Hello";
    }


}
