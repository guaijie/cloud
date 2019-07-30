package com.example.demo.detail;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UserDetails {

    // 返回分配给用户的角色列表
    Collection<? extends GrantedAuthority> getAuthorities();

    // 返回密码
    String getPassword();

    // 返回用户名
    String getUsername();

    // 账户是否未过期
    boolean isAccountNonLocked();

    // 账户是否未锁定
    boolean isAccountNounLocked();

    // 密码是否未过期
    boolean isCredentialsNonExpired();

    // 账户是否激活
    boolean isEnabled();
}
