package com.example.demo.service.impl;

import com.example.demo.detail.UserDetails;
import com.example.demo.service.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    /**
     * @Title: loadUserByUsername
     * @Description: ${todo}
     * @param name
     * @return: com.example.demo.detail.UserDetails
     * @throws
     * @author: xxxxx
     * @Date: 2019/6/21/17:37
     */
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return null;
    }
}
