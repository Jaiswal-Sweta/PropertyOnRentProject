package com.example.adminservices.repo;

import com.example.adminservices.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleCrud extends JpaRepository<RoleModel,Integer>
{

}
