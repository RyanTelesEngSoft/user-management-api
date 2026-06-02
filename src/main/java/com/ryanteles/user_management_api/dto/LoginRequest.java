package com.ryanteles.user_management_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @Email(message = "Email inválido!")
    @NotBlank(message = "Email obrigatório!")
    private String email;

    @Size(min = 6, message = "Mínimo 6 caracteres para senha!")
    @NotBlank(message = "Senha obrigatória!")
    private String senha;
}
