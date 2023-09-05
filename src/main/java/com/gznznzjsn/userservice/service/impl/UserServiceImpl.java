package com.gznznzjsn.userservice.service.impl;

import com.gznznzjsn.userservice.domain.User;
import com.gznznzjsn.userservice.exception.ResourceNotFoundException;
import com.gznznzjsn.userservice.exception.UniqueResourceException;
import com.gznznzjsn.userservice.repository.UserDao;
import com.gznznzjsn.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public User get(Long userId) {
        return userDao.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " doesn't exist!"));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email) {
        return userDao.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));
    }

    @Override
    @Transactional
    public User create(User user) {
        if(userDao.findByEmail(user.getEmail()).isPresent()){
            throw new UniqueResourceException("User with email " + user.getEmail() + " already exists!");
        }
        userDao.create(user);
        return user;
    }

}
