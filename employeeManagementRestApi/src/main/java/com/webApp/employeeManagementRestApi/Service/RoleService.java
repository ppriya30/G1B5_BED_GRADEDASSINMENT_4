package com.webApp.employeeManagementRestApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webApp.employeeManagementRestApi.Entity.Role;
import com.webApp.employeeManagementRestApi.Repository.RoleRepo;
import com.webApp.employeeManagementRestApi.ServiceInterface.RoleServiceInterface;

@Service
public class RoleService implements RoleServiceInterface {

	@Autowired
	RoleRepo userRoleRepo;

	@Override
	public Role addrole(Role userRole) {

		return userRoleRepo.save(userRole);
	}

}
