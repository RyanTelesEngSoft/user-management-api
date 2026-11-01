package com.ryanteles.user_management_api.controller;

import com.ryanteles.user_management_api.dto.LoginRequest;
import com.ryanteles.user_management_api.dto.TokenResponseDTO;
import com.ryanteles.user_management_api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;


    @PostMapping("/login")
    public TokenResponseDTO login (@Valid @RequestBody LoginRequest dto) {

        return service.login(dto);
    }
}
