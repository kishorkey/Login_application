package com.Test.Demo.Service;

import com.Test.Demo.Entity.UserDetails;
import com.Test.Demo.Entity.UserRole;

public interface Testdemoservice {

	public UserDetails getUserDetails(String username);

	public UserDetails saveUserDetails(UserDetails userdetails);

	public String login(String username, String password);

	public UserRole getUserRoles(String username);

	public UserRole saveUserRoles(UserRole usertbs);

}
