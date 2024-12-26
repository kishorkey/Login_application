package com.Test.Demo.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Test.Demo.Entity.UserDetails;
import com.Test.Demo.Entity.UserRole;
import com.Test.Demo.Repository.UserDetailsRepo;
import com.Test.Demo.Service.Testdemoservice;

@RestController
public class testDemocontroller {
	
	@Autowired
	private Testdemoservice  testdemoservice;
	
	
    @GetMapping(path = "/getUser") 
    public ResponseEntity<Object> getUser(@RequestParam String username) 
    { 
    	 UserDetails responseBody = testdemoservice.getUserDetails(username);
    	 return new ResponseEntity<>(responseBody, HttpStatus.OK);
    } 
    
    @PostMapping(path = "/saveUser") 
    public ResponseEntity<Object> saveUser(@RequestBody UserDetails userDetails) 
    { 
    	 testdemoservice.saveUserDetails(userDetails);
    	 return new ResponseEntity<> (HttpStatus.OK);
    } 
    
    @GetMapping(path = "/login") 
    public ResponseEntity<String> login(@RequestParam String username , @RequestParam String password) 
    { 
    	try
    	{
    		String valid =  testdemoservice.login(username, password);
       	 return new ResponseEntity<> (valid,HttpStatus.OK);
    	}
    	catch (Exception e) {
    		String valid =  testdemoservice.login(username, password);
          	 return new ResponseEntity<> (valid,HttpStatus.OK);
		}
    
    } 
    
    
    @GetMapping(path = "/getUserroles") 
    public ResponseEntity<Object> getUserRoles(@RequestParam String username) 
    { 
    	 UserRole responseBody = testdemoservice.getUserRoles(username);
    	 return new ResponseEntity<>(responseBody, HttpStatus.OK);
    } 
    
    
    @PostMapping(path = "/saveUserRole") 
    public ResponseEntity<Object> saveUserRole(@RequestBody UserRole userrole) 
    { 
    	 testdemoservice.saveUserRoles(userrole);
    	 return new ResponseEntity<> (HttpStatus.OK);
    } 

}
