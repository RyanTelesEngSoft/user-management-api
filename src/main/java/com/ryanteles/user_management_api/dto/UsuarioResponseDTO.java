package com.ryanteles.user_management_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioResponseDTO {
    private Long id;
    private String name;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String email;
}
