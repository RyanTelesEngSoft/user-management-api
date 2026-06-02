package com.ryanteles.user_management_api.controller;

import com.ryanteles.user_management_api.dto.LoginRequest;
import com.ryanteles.user_management_api.service.AuthService;
import com.ryanteles.user_management_api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {

        this.service = service;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest dto) {

        return service.login(dto);
    }
}
