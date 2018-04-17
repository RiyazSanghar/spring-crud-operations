/**
 * 
 */
package com.jpa.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author anand
 *
 */

@RestController
public class HelloController {
	


	@RequestMapping(value = "/principal", method = RequestMethod.GET)
	public Principal user(Principal principal)
	{
		return principal;
	}
	@RequestMapping(value  = "/hello", method = RequestMethod.GET)
	public String Hello()
	{
		return "Hello World";
	}

}
