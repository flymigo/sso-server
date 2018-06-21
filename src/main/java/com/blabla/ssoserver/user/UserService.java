package com.blabla.ssoserver.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 需要扩展业务实现
 */
@Component
public class UserService {
	@Autowired
	private  PasswordEncoder encoder;
	
	public AppUser	findUserByName(String userName) {
		AppUser user=new AppUser();
		user.setUsername(userName);
		user.setPassword(encoder.encode("123456"));
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);		
		List<String> authority=new ArrayList<String>();
		authority.add("ROLE_USER");
		user.setAuthority(authority);
		return user;		
	}
}
