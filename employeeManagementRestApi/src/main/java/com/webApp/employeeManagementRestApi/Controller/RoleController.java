package com.webApp.employeeManagementRestApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.employeeManagementRestApi.Entity.Role;
import com.webApp.employeeManagementRestApi.Service.UserDetailsServiceImpl;
import com.webApp.employeeManagementRestApi.ServiceInterface.RoleServiceInterface;

@RestController
@RequestMapping("/Employee")
public class RoleController {

	@Autowired
	private RoleServiceInterface userRoleService;

	@PostMapping("/addrole")
	public Role addrole(@RequestBody Role userRole1) {

		return userRoleService.addrole(userRole1);
	}

}
