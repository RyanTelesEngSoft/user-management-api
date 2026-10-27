package com.ryanteles.user_management_api.repository;

import com.ryanteles.user_management_api.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository  extends JpaRepository<RoleEntity, Long> {
}
