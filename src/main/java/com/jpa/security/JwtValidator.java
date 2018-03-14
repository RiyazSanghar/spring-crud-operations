package com.jpa.security;


import com.jpa.entity.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secretKey = "youtube";

    private Logger logger = LoggerFactory.getLogger(JwtValidator.class);



    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();


            jwtUser = new JwtUser();

            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String)body.get("userId")));
            jwtUser.setRole((String)body.get("role"));
        }
        catch (Exception e)
        {
            logger.info("Error Occured in Validate Method: {}",e);
        }




        return jwtUser;
    }
}
