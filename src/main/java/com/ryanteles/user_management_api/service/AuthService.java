package com.ryanteles.user_management_api.service;

import com.ryanteles.user_management_api.dto.LoginRequest;
import com.ryanteles.user_management_api.entity.Usuario;
import com.ryanteles.user_management_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String login(LoginRequest login) {

        for (Usuario usuario : usuarioRepository.findAll()) {

            if (usuario.getEmail().equals(login.getEmail()) && usuario.getSenha().equals(login.getSenha())) {

                return "Login realizado!";
            }
        }

        return "Login ou senha inválidos!";
    }
}
