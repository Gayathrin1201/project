package com.project.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.model.UserInfo;
import com.project.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	 @Autowired
     private UserInfoRepository userInfoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
			UserInfo userinfo=userInfoRepository.findByName(username);
//			return userinfo.map(UserInfoUserDetails::new)
//			.orElseThrow(()->new UsernameNotFoundException("user not found"+username));
			if(userinfo==null)
			{
				throw new UsernameNotFoundException("user not found"+username);
			}
			return new UserInfoUserDetails(userinfo);
//			
	}
 
}
