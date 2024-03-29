package com.java668.oxadmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * @author Jerry
 */
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            return new User("admin", passwordEncoder.encode("1234"),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("product"));
    }

}
