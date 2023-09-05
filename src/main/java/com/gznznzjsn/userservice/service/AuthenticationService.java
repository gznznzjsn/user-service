package com.gznznzjsn.userservice.service;


import com.gznznzjsn.userservice.domain.AuthEntity;

public interface AuthenticationService {

    AuthEntity register(AuthEntity authEntity);

    AuthEntity authenticate(AuthEntity authEntity);

    AuthEntity refresh(AuthEntity authEntity);

    AuthEntity validate(AuthEntity authEntity);
}
