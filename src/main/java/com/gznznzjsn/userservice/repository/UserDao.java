package com.gznznzjsn.userservice.repository;

import com.gznznzjsn.userservice.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserDao {

    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);

    void create(User user);

}
