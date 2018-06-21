package com.blabla.ssoserver.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class ProxyUserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;

	private AppUser appUser;

	public ProxyUserDetail(AppUser appUser) {
		super();
		this.appUser = appUser;
	}

	
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();  
        for(String role:appUser.getAuthority()) {
        	GrantedAuthority au = new SimpleGrantedAuthority(role);  
        	list.add(au); 
        }         
        return list;  
	}

	
	public String getPassword() {
		// TODO Auto-generated method stub
		return appUser.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return appUser.getUsername();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return appUser.isAccountNonExpired();
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return appUser.isAccountNonLocked();
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return appUser.isCredentialsNonExpired();
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return appUser.isEnabled();
	}

}
