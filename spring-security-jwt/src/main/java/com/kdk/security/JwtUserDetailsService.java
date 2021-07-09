package com.kdk.security;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.kdk.service.UserService;
import com.kdk.user.User;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
    private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> userOptional = userService.findUserByEmail(email);

    User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("user email not found!"));
    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        "1", new ArrayList<>());
  }
}
