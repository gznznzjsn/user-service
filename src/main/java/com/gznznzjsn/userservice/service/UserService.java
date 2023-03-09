package com.gznznzjsn.userservice.service;

import com.gznznzjsn.userservice.domain.User;

public interface UserService {

    User get(Long userId);

    User getByEmail(String email);

    User create(User user);

}
