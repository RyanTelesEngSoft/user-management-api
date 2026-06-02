package com.ryanteles.user_management_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Email obrigatório!")
    @Email(message = "Email inválido!")
    private String email;

    @NotBlank(message = "Senha obrigatória!")
    @Size(min = 6, message = "Mínimo 6 caracteres para senha!")
    private String senha;
}
