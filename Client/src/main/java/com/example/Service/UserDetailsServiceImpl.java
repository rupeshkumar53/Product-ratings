package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Model.Client;
import com.example.Repostory.ClientRepositry;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	
	@Autowired
	private ClientRepositry clientRepositry;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client user = clientRepositry.findByUserName(username);
		if(user!=null) {
			return org.springframework.security.core.userdetails.User
					.withUsername(user.getUserName())
					.password(user.getPassword())
					.roles("User")
					.build();
		}throw new UsernameNotFoundException("User not found with UserName : "+username);
	}


}
