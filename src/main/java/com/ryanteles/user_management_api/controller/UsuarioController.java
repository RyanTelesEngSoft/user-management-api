package com.ryanteles.user_management_api.controller;

import com.ryanteles.user_management_api.dto.UsuarioRequestDTO;
import com.ryanteles.user_management_api.dto.UsuarioResponseDTO;
import com.ryanteles.user_management_api.model.Usuario;
import com.ryanteles.user_management_api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

        private final UsuarioService service;

        public UsuarioController(UsuarioService service) {
            this.service = service;
        }

    @PostMapping
    public String cadastrar(@Valid @RequestBody UsuarioRequestDTO dto){

        service.cadastrar(dto);

        return "Usuario Cadastrado!";
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable Long id, @RequestBody UsuarioRequestDTO dto) {

        return service.atualizar(id, dto);
    }
}
