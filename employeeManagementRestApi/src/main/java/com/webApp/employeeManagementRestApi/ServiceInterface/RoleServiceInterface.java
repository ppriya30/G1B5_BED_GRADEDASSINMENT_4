package com.webApp.employeeManagementRestApi.ServiceInterface;

import org.springframework.stereotype.Service;

import com.webApp.employeeManagementRestApi.Entity.Role;

@Service
public interface RoleServiceInterface {

	Role addrole(Role userRole);

}