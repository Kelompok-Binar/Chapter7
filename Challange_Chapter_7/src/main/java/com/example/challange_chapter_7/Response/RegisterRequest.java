package com.example.challange_chapter_7.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private int id_user;
    private String username;
    private String email;
    private String password;
    private String roles;
}
