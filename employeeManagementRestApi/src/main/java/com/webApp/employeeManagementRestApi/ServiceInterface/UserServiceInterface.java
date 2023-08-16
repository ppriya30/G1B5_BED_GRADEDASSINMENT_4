package com.webApp.employeeManagementRestApi.ServiceInterface;

import org.springframework.stereotype.Service;

import com.webApp.employeeManagementRestApi.Entity.User;

@Service
public interface UserServiceInterface {

	User adduser(User user1);

}