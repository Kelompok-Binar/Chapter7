package com.example.challange_chapter_7.Security;

import com.example.challange_chapter_7.Model.UsersEntity;
import com.example.challange_chapter_7.Repository.UsersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersInterface ui;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsersEntity> userinfo = ui.findByUsername(username);
        return userinfo.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("Username Doesn't Exsist" + username));

    }
}
