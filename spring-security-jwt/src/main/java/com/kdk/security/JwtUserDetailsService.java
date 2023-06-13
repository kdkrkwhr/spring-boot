package com.kdk.security;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.kdk.service.UserService;
import com.kdk.user.User;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> userOptional = userService.findUserByEmail(email);

    log.info("detail email: {}", email);
    User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("user email not found!"));
    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        "1", new ArrayList<>());
  }
}
