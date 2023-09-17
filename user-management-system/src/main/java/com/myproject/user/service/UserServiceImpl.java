package com.myproject.user.service;

import com.myproject.user.entity.UserEntity;
import com.myproject.user.model.User;
import com.myproject.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User saveUser(User user) {
    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(user, userEntity);
    repository.save(userEntity);
    return user;
  }

  @Override
  public List<User> getAllUsers() {
    List<UserEntity> userEntities = repository.findAll();
    return userEntities.stream()
        .map(
            user ->
                new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmailId()))
        .toList();
  }

  @Override
  public Optional<User> getUserById(Long id) {
    Optional<UserEntity> optionalUserEntity = repository.findById(id);
    User user =
        optionalUserEntity
            .map(
                userEntity ->
                    new User(
                        userEntity.getId(),
                        userEntity.getFirstName(),
                        userEntity.getLastName(),
                        userEntity.getEmailId()))
            .orElse(null);
    return Optional.ofNullable(user);
  }

  @Override
  public boolean deleteUserById(Long id) {
    repository.deleteById(id);
    return true;
  }

  @Override
  public User updateUser(User user) {
    UserEntity userEntity = repository.findById(user.id()).get();
    userEntity.setFirstName(user.firstName());
    userEntity.setLastName(user.lastName());
    userEntity.setEmailId(user.emailId());
    repository.save(userEntity);
    return user;
  }
}
