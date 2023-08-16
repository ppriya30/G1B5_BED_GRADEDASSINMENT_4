package com.webApp.employeeManagementRestApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webApp.employeeManagementRestApi.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.userName = ?1")
	public User getUserByUsername(String username);

}
