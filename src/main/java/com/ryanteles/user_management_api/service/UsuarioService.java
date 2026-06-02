package com.ryanteles.user_management_api.service;


import com.ryanteles.user_management_api.dto.UsuarioRequestDTO;
import com.ryanteles.user_management_api.dto.UsuarioResponseDTO;
import com.ryanteles.user_management_api.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private static final List<Usuario> usuarios = new ArrayList<>();
    private Long contadorId = 1L;

    public void cadastrar(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setId(contadorId);
        contadorId++;

        usuario.setNome(dto.getNome());
        usuario.setSobrenome(dto.getSobrenome());
        usuario.setDataNascimento(dto.getDataNascimento());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        usuarios.add(usuario);
    }



    public String remover(Long id){

        for(int i = 0; i < usuarios.size(); i++){

            if(usuarios.get(i).getId().equals(id)){

                usuarios.remove(i);

                return "Usuario removido!";
            }
        }

        return "Usuario não encontrado";
    }

    public List<UsuarioResponseDTO> listar() {

        List<UsuarioResponseDTO> resposta = new ArrayList<>();

        for (Usuario usuario : usuarios) {

            UsuarioResponseDTO dto = new UsuarioResponseDTO();

            dto.setId(usuario.getId());

            dto.setNome(usuario.getNome());

            dto.setSobrenome(usuario.getSobrenome());

            dto.setDataNascimento(usuario.getDataNascimento());

            dto.setEmail(usuario.getEmail());

            resposta.add(dto);
        }

        return resposta;
    }

    public String atualizar(Long id, UsuarioRequestDTO dto) {

        for (Usuario usuario : usuarios) {

            if (usuario.getId().equals(id)) {

                if (dto.getNome() != null && !dto.getNome().isBlank()) {

                    usuario.setNome(dto.getNome());
                }

                if (dto.getSobrenome() != null && !dto.getSobrenome().isBlank()) {

                    usuario.setSobrenome(dto.getSobrenome());
                }

                if (dto.getEmail() != null && !dto.getEmail().isBlank()) {

                    usuario.setEmail(dto.getEmail());
                }

                if (dto.getSenha() != null && !dto.getSenha().isBlank()) {

                    usuario.setSenha(dto.getSenha());
                }

                if (dto.getDataNascimento() != null) {

                    usuario.setDataNascimento(dto.getDataNascimento());
                }

                return "Usuario atualizado!";
            }
        }

        return "Usuario não encontrado!";
    }
    public List<Usuario> listarUsuarios() {

        return usuarios;
    }
}
