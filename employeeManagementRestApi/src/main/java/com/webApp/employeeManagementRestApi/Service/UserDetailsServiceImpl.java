package com.webApp.employeeManagementRestApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webApp.employeeManagementRestApi.Entity.Role;
import com.webApp.employeeManagementRestApi.Entity.User;
import com.webApp.employeeManagementRestApi.Repository.UserRepo;
import com.webApp.employeeManagementRestApi.WebSecurity.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repo.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not found User");
		}

		return new MyUserDetails(user);
	}

}
