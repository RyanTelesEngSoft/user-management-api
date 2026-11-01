package com.ryanteles.user_management_api.repository;

import com.ryanteles.user_management_api.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository  extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity>findByNome(String nome);
}
