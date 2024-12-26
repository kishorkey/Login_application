package com.Test.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Test.Demo.Entity.UserRole;

public interface UserRoleRepo  extends JpaRepository<UserRole, String>{
	
	@Query(nativeQuery = true, value = "select * from public.UserRole where username = :username")
	public UserRole getuserRolesByUsername(String username);

}
