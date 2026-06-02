package com.ryanteles.user_management_api.service;

import com.ryanteles.user_management_api.dto.LoginRequest;
import com.ryanteles.user_management_api.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioService usuarioService;

    public AuthService(UsuarioService usuarioService) {

        this.usuarioService =
                usuarioService;
    }

    public String login(LoginRequest login) {

        for (Usuario usuario : usuarioService.listarUsuarios()) {

            if (usuario.getEmail().equals(login.getEmail()) && usuario.getSenha().equals(login.getSenha())) {

                return "Login realizado!";
            }
        }

        return "Login ou senha inválidos!";
    }
}
