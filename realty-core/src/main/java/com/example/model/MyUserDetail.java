package com.example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MyUserDetail extends User {

	private static final long serialVersionUID = -5537682678805566889L;

	public MyUserDetail(String username, String password, boolean enabled, boolean accountNonExpired,
											boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	private Long id;
	private String fullName;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
