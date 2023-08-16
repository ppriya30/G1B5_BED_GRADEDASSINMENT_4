package com.webApp.employeeManagementRestApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webApp.employeeManagementRestApi.Entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

	Role save(Role userRole);

}
