package com.ryanteles.user_management_api.service;

import com.ryanteles.user_management_api.config.TokenProvider;
import com.ryanteles.user_management_api.dto.LoginRequest;
import com.ryanteles.user_management_api.dto.TokenResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    public TokenResponseDTO login(LoginRequest login) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha())
        );

        String token = tokenProvider.gerarToken(authentication);
        return TokenResponseDTO.builder().token(token).type("Bearer").expiration(tokenProvider.getExpirationTime()).build();
    }
}
