package com.Test.Demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.Demo.Entity.UserDetails;
import com.Test.Demo.Entity.UserRole;
import com.Test.Demo.Repository.UserDetailsRepo;
import com.Test.Demo.Repository.UserRoleRepo;
import com.Test.Demo.Security.EncryptionUtil;

@Service
public class TestdemoserviceImpl implements Testdemoservice{
	
	
	@Autowired
	private UserDetailsRepo  userdetailsrepo;
	
	@Autowired
	private UserRoleRepo  userrolerepo;
	
	
	@Autowired
	private EncryptionUtil encryptionUtil;
	
	
	@Override
	public UserDetails getUserDetails(String username)
	{
		UserDetails user = userdetailsrepo.getuserDetailsByUser(username);
//		user.setPassword(encryptionUtil.decrypt(user.getPassword()));
		 return user;
	}
	
	
	@Override
	public UserDetails saveUserDetails(UserDetails userdetails)
	{
		userdetails.setPassword(encryptionUtil.encrypt(userdetails.getPassword()));
		return userdetailsrepo.save(userdetails);
	}
	
	@Override
	public String login(String username,String password)
	{
		String valieduser ;
		UserDetails user = userdetailsrepo.getuserDetailsByUser(username);
		user.setPassword(encryptionUtil.decrypt(user.getPassword()));
		if(password.equalsIgnoreCase(user.getPassword()))
		{
			valieduser = "Login Successfull";
		}
		else 
		{
			valieduser = "login Failed" ;
		}
		 return valieduser;
	}
	
	
	@Override
	public UserRole getUserRoles(String username)
	{
		UserRole user = userrolerepo.getuserRolesByUsername(username);
		 return user;
		
	}
	
	
	@Override
	public UserRole saveUserRoles(UserRole usertbs)
	{
		return userrolerepo.save(usertbs);
	}
	

}
