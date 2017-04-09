package com.tms.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
public Authentication authenticate(Authentication authentication ) throws AuthenticationException {
    String userName = authentication.getName().trim();
        
        Authentication auth = null;
        Collection<GrantedAuthority> grantedAuths = Arrays.asList( new SimpleGrantedAuthority("USER"));
        User  appUser = new User(userName,"",grantedAuths);
        auth = new UsernamePasswordAuthenticationToken(appUser, "", grantedAuths);
            return auth;

    }
    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
    }
