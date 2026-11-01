package com.ryanteles.user_management_api.service;



import com.ryanteles.user_management_api.dto.UsuarioRequestDTO;
import com.ryanteles.user_management_api.dto.UsuarioResponseDTO;
import com.ryanteles.user_management_api.entity.RoleEntity;
import com.ryanteles.user_management_api.entity.Usuario;
import com.ryanteles.user_management_api.enums.RoleTypeEnum;
import com.ryanteles.user_management_api.exception.BadRequestException;
import com.ryanteles.user_management_api.exception.UsuarioNotFoundException;
import com.ryanteles.user_management_api.repository.RolesRepository;
import com.ryanteles.user_management_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO usuarioResponseDTO(Usuario usuario){
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setId(usuario.getId());
        usuarioResponseDTO.setNome(usuario.getNome());
        usuarioResponseDTO.setSobrenome(usuario.getSobrenome());
        usuarioResponseDTO.setDataNascimento(usuario.getDataNascimento());
        usuarioResponseDTO.setEmail(usuario.getEmail());
        return usuarioResponseDTO;
    }

    public UsuarioResponseDTO cadastrar (UsuarioRequestDTO usuarioRequestDTO) throws BadRequestException {

        if(usuarioRepository.findByEmail(usuarioRequestDTO.getEmail()).isPresent()){
            throw new BadRequestException("Email já cadastrado!");
        }

        RoleEntity role = rolesRepository.findByNome(RoleTypeEnum.BASIC.name()).orElseGet(()-> rolesRepository
                .save(RoleEntity
                .builder()
                .nome(RoleTypeEnum.BASIC.name())
                .build()));

        Usuario usuario = usuarioRepository.save(Usuario.builder()
                .nome(usuarioRequestDTO.getNome())
                .sobrenome(usuarioRequestDTO.getSobrenome())
                .dataNascimento(usuarioRequestDTO.getDataNascimento())
                .email(usuarioRequestDTO.getEmail())
                .senha(passwordEncoder.encode(usuarioRequestDTO.getSenha()))
                .roles(Set.of(role))
                .build());

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
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNotFoundException("Usuario não encontrado!"));
        return usuarioResponseDTO(usuario);
    }

    public void deletar (Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNotFoundException("Usuario não encontrado!"));
        usuarioRepository.deleteById(id);
    }

    public UsuarioResponseDTO atualizar (Long id, UsuarioRequestDTO usuarioAtualziado){
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNotFoundException("Usuario não encontrado!"));
        usuarioExistente.setNome(usuarioAtualziado.getNome());
        usuarioExistente.setSobrenome(usuarioAtualziado.getSobrenome());
        usuarioExistente.setDataNascimento(usuarioAtualziado.getDataNascimento());
        usuarioExistente.setEmail(usuarioAtualziado.getEmail());
        usuarioExistente.setSenha(usuarioAtualziado.getSenha());
        usuarioRepository.save(usuarioExistente);
        return usuarioResponseDTO(usuarioExistente);
    }
}