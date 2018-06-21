package com.blabla.ssoserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetailsService implements UserDetailsService {	
	
	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user=userService.findUserByName(username);
		if(user==null) throw  new UsernameNotFoundException("UserName "+username +" not found");		
		ProxyUserDetail normalUserDetail=new ProxyUserDetail(user);		
		return normalUserDetail;
	}

}
