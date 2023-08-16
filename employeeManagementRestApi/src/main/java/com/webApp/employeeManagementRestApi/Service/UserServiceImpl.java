package com.webApp.employeeManagementRestApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webApp.employeeManagementRestApi.Entity.Role;
import com.webApp.employeeManagementRestApi.Entity.User;
import com.webApp.employeeManagementRestApi.Repository.UserRepo;
import com.webApp.employeeManagementRestApi.ServiceInterface.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User adduser(User user1) {

		User avilUser = userRepo.getUserByUsername(user1.getUserName());
		if (avilUser == null) {
			user1.setPassword(bCryptPasswordEncoder.encode(user1.getPassword()));
			user1.setRole(user1.getRole());
			return userRepo.save(user1);
		} else {
			List<Role> role = avilUser.getRole();
			role.addAll(user1.getRole());
			avilUser.setRole(role);
			return userRepo.save(avilUser);
		}
	}

}
