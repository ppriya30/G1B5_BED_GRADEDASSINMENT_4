package com.webApp.employeeManagementRestApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.employeeManagementRestApi.Entity.User;
import com.webApp.employeeManagementRestApi.Service.UserDetailsServiceImpl;
import com.webApp.employeeManagementRestApi.ServiceInterface.UserServiceInterface;

@RestController
@RequestMapping("/Employee")
public class UserController {

	@Autowired
	private UserServiceInterface userServiceImpl;

	@PostMapping("/adduser")
	public User adduser(@RequestBody User user1) {
		return userServiceImpl.adduser(user1);
	}

}
