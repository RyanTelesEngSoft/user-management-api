package com.ryanteles.user_management_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequestDTO {
    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome obrigatório")
    private String sobrenome;

    @NotNull(message = "Data de nascimento obrigatória")
    private LocalDate dataNascimento;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email obrigatório")
    private String email;

    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    @NotBlank(message = "Senha obrigatória")
    private String senha;



}
