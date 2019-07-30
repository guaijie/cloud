/****************************************************
 * 创建人: @author zhangkuangwen    
 * 创建时间: 2019/7/29/17:25
 * 项目名称: eureka
 * 文件名称: WebSecurityConfig.java
 * 文件描述: @Description: create global security config
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.example.eureka.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 包名称：com.example.eureka.configs
 * 类名称：WebSecurityConfig
 * 类描述：create global security config
 * 创建人：@author zhangkuangwen
 * 创建时间：2019/7/29/17:25
 */
//@EnableWebSecurity
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public UserDetailsService userDetailsService(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        manager.createUser(User.builder().username("user").password(encoder.encode("password")).roles("USER").build());
        return manager;
    }


}
