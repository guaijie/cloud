package com.example.demo.service;

import com.example.demo.detail.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

    UserDetails loadUserByUsername(String name) throws UsernameNotFoundException;
}
