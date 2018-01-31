/**
 * 
 */
package com.jpa.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anand
 *
 */

@RestController
public class HelloController {
	
	
	@RequestMapping(value  = "/hello", method = RequestMethod.GET)
	public String Hello()
	{
		return "Hello World";
	}

}
