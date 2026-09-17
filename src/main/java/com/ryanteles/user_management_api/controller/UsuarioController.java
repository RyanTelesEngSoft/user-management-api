package com.ryanteles.user_management_api.controller;

import com.ryanteles.user_management_api.dto.UsuarioRequestDTO;
import com.ryanteles.user_management_api.dto.UsuarioResponseDTO;
import com.ryanteles.user_management_api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

        private final UsuarioService usuarioService;

        public UsuarioController(UsuarioService service) {
            this.usuarioService = service;
        }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO usuarioCriado = usuarioService.cadastrar(usuarioRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioCriado.getId()).toUri();
        return ResponseEntity.created(location).body(usuarioCriado);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar(){
       return usuarioService.listar();
       
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id){
            return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar (@PathVariable Long id,@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
          return usuarioService.atualizar(id, usuarioRequestDTO);
    }
}
