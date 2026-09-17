package com.ryanteles.user_management_api.service;



import com.ryanteles.user_management_api.dto.UsuarioRequestDTO;
import com.ryanteles.user_management_api.dto.UsuarioResponseDTO;
import com.ryanteles.user_management_api.entity.Usuario;
import com.ryanteles.user_management_api.exception.UsuarioNotFoundException;
import com.ryanteles.user_management_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO usuarioResponseDTO(Usuario usuario){
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setId(usuario.getId());
        usuarioResponseDTO.setNome(usuario.getNome());
        usuarioResponseDTO.setSobrenome(usuario.getSobrenome());
        usuarioResponseDTO.setDataNascimento(usuario.getDataNascimento());
        usuarioResponseDTO.setEmail(usuario.getEmail());
        return usuarioResponseDTO;
    }

    public UsuarioResponseDTO cadastrar (UsuarioRequestDTO usuarioRequestDTO){
        if(usuarioRequestDTO == null){
            throw new IllegalArgumentException("O usuario não pode está vazio");
        }
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setSobrenome(usuarioRequestDTO.getSobrenome());
        usuario.setDataNascimento(usuarioRequestDTO.getDataNascimento());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuarioRepository.save(usuario);
        return usuarioResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> listar (){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> usuariosResponseDTO = new ArrayList<>();
        for(Usuario usuario : usuarios){
            usuariosResponseDTO.add(usuarioResponseDTO(usuario));
        }
        return usuariosResponseDTO;
    }

    public UsuarioResponseDTO buscarPorId(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findAllById(id);
        Usuario usuario = usuarioOptional.orElseThrow(()-> new UsuarioNotFoundException("Usuario não encontrado!"));
        return usuarioResponseDTO(usuario);
    }

    public void deletar (Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNotFoundException("Usuario não encontrado!"));
        usuarioRepository.deleteById(id);
    }

}