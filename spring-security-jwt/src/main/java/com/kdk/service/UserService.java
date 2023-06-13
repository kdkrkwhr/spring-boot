package com.kdk.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kdk.user.Role;
import com.kdk.user.User;
import com.kdk.user.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public void save(User user) {
    repository.save(User.builder().email(user.getEmail()).name(user.getName())
        .picture(user.getPicture()).role(Role.USER).build());
  }

  public Optional<User> findUserByEmail(String email) {
    Optional<User> accountUser = repository.findByEmail(email);
    return accountUser;
  }
}
