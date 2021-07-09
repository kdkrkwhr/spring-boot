package com.kdk.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.kdk.security.CustomOAuth2UserService;
import com.kdk.user.Role;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final CustomOAuth2UserService customOAuth2UserService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().headers().frameOptions().disable().and().authorizeRequests()
        .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2/**", "/h2-console/**", "/api/**").permitAll()
        .antMatchers("/user/**").hasRole(Role.USER.name()).anyRequest().authenticated().and()
        .logout().logoutSuccessUrl("/").and().oauth2Login().userInfoEndpoint()
        .userService(customOAuth2UserService);
  }
}
