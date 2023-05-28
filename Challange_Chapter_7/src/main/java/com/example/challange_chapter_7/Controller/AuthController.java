package com.example.challange_chapter_7.Controller;

import com.example.challange_chapter_7.Model.UsersEntity;
import com.example.challange_chapter_7.Response.AuthRequest;
import com.example.challange_chapter_7.Response.RegisterRequest;
import com.example.challange_chapter_7.Service.JwtService;
import com.example.challange_chapter_7.Service.UsersService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value ="/Auth")
@Api(value = "Authentication")
public class AuthController {
    @Autowired
    UsersService us;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/Authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return String.valueOf(jwtService.generateToken(authRequest.getUsername()));
        }
        else {
            throw new UsernameNotFoundException("Invalid user resquest !");
        }

    }
}
