package com.ryanteles.user_management_api.repository;

import com.ryanteles.user_management_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
